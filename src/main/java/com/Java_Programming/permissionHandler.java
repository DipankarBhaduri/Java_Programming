//package com.Java_Programming;
//
//package com.tech.medicea.core.services.handlers.permission;
//
//import com.tech.medicea.core.exception.NotFoundException;
//import com.tech.medicea.core.models.builder.Form;
//import com.tech.medicea.core.models.builder.Grid;
//import com.tech.medicea.core.models.builder.Template;
//import com.tech.medicea.core.models.builder.TemplateTab;
//import com.tech.medicea.core.models.generic.ApplicationUser;
//import com.tech.medicea.core.models.generic.Menu;
//import com.tech.medicea.core.models.generic.ProjectModules;
//import com.tech.medicea.core.models.generic.exception.ExceptionTrace;
//import com.tech.medicea.core.models.permissions.appPermissions.*;
//import com.tech.medicea.core.services.repository.CollectionHandler;
//import com.tech.medicea.core.util.DBInteraction.*;
//import com.tech.medicea.core.util.Reference;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Component
//public class PermissionHandler {
//    @Autowired
//    private CollectionHandler collectionHandler;
//
//    private Map<String,HashSet<String>> userIdAndTemplateTabIdSetMap = new HashMap<>() ;
//    private Map<String,HashSet<String>> userIdAndModuleIdSetMap = new HashMap<>() ;
//    Map<String,Template> templateMap = new HashMap<>() ;
//    Map<String,TemplateTab> templateTabMap = new HashMap<>() ;
//
//
//
//    public TreeMap<String, AppResourceModule>  getPermissionLists (ApplicationUser currentUser ){
//
//        /*
//         Fetching all Templates From DB at the starting of application
//         */
//        List<Template> templates = collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(Template.class)
//                .build());
//
//        if (templates != null && templates.size() > 0 ){
//            for (Template template : templates) {
//                if (template.getName() != null) {
//                    templateMap.put(template.getName(), template);
//                }
//            }
//        }
//
//         /*
//           Fetching all TemplateTab From DB at the starting of application
//         */
//        List<TemplateTab> templateTabList = collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(TemplateTab.class)
//                .build());
//
//        if (templateTabList != null ){
//            for (TemplateTab templateTab : templateTabList) {
//                if (templateTab.get_id() != null) {
//                    templateTabMap.put(templateTab.get_id(), templateTab);
//                }
//            }
//        }
//
//        String userid = currentUser.get_id();
//        /*
//         * Initializing empty lists for references to application users , user groups , and group of groups.
//         */
//        List<Reference> applicationUserReferenceList = new ArrayList<>();
//        List<Reference> appUsersGroupReferenceList = new ArrayList<>();
//        List<Reference> appGroupOfGroupReferenceList = new ArrayList<>();
//
//        /*
//         *Creating empty maps to store the app role binding subjects and app role lists.
//         */
//        Map<String, List<AppRoleBindingSubject>> appRoleBindingSubjectMap = new HashMap<>();
//        Map<String, List<Reference>> appRoleReferenceListMap = new HashMap<>();
//
//        /*
//         * Retrieving a list of app role bindings from the database, including the selected columns.
//         */
//        List<AppRoleBinding> appRoleBindingList = getRoleBindingList();
//
//        /*
//         * Iterate over each appRoleBinding in appRoleBindingList.
//         * - Store appRoleBinding names and corresponding appRoleBindingSubjectList in appRoleBindingSubjectMap.
//         * - Store appRoleBinding names and corresponding appRoleList in appRoleListMap.
//         * - Collect references to different types of users from appRoleBindingSubjectList:
//         * - Add AppApplicationUser references to applicationUserReferenceList.
//         * - Add AppUserGroup references to appUsersGroupReferenceList.
//         * - Add AppUserGroupOfGroup references to appGroupOfGroupReferenceList.
//         */
//        populateApplicationUserReferencesAndUserGroupsReferencesAndGroupOfGroupReferences(applicationUserReferenceList,
//                appUsersGroupReferenceList,
//                appGroupOfGroupReferenceList,
//                appRoleBindingSubjectMap,
//                appRoleReferenceListMap,
//                appRoleBindingList);
//
//        /*
//         *  Retrieves a list of AppGroupOfGroup objects based on the provided list of appGroupOfGroupReferenceList.
//         *  appGroupOfGroupReferenceList The list of references to AppGroupOfGroup objects.
//         *  A list of AppGroupOfGroup objects matching the provided references.
//         */
//        List<AppGroupOfGroup> appGroupOfGroupList = getAppGroupOfGroupList(appGroupOfGroupReferenceList);
//
//
//        /*
//         * Retrieves a list of AppUsersGroup objects based on the provided appUsersGroupReferenceList and appGroupOfGroupList.
//         * appUsersGroupReferenceList The list of references to AppUsersGroup objects.
//         * appGroupOfGroupList The list of AppGroupOfGroup objects.
//         * A list of AppUsersGroup objects matching the provided references.
//         */
//        List<AppUsersGroup> appUsersGroupList = getUsersGroupList(appUsersGroupReferenceList, appGroupOfGroupList);
//
//        /*
//         Creating the appGroupOfGroupMap
//         */
//        Map<String, AppGroupOfGroup> appGroupOfGroupMap = appGroupOfGroupList.stream().collect(Collectors.toMap(AppGroupOfGroup::get_id, Function.identity()));
//
//        /*
//         Creating the appUsersGroupMap
//         */
//        Map<String, AppUsersGroup> appUsersGroupMap = appUsersGroupList.stream().collect(Collectors.toMap(AppUsersGroup::get_id, Function.identity()));
//
//        /*
//         Using Stream API to set the transientAppUsersGroup property for each element in appGroupOfGroupList
//         */
//        appGroupOfGroupList
//                .stream()
//                .forEach(appGroupOfGroup -> appGroupOfGroup
//                        .setTransientAppUsersGroup(appGroupOfGroup.getAppGroupList()
//                                .stream()
//                                .map(userGroupRef -> appUsersGroupMap.get(userGroupRef.get_id()))
//                                .collect(Collectors.toList()))
//                );
//
//        /*
//          Get ApplicationUser from applicationUserReferenceList , appGroupOfGroupList And appUsersGroupList
//         */
//        List<ApplicationUser> appApplicationUserList = getAppApplicationUserList(applicationUserReferenceList, appGroupOfGroupList, appUsersGroupList);
//
//        /*
//         Creating the applicationUserMap from appApplicationUserList
//         */
//        Map<String, ApplicationUser> applicationUserMap = appApplicationUserList.stream().collect(Collectors.toMap(ApplicationUser::get_id, Function.identity()));
//
//        appUsersGroupList
//                .forEach(appUsersGroup -> {
//                    List<Reference> appUserApproverList = appUsersGroup.getAppUserApprover();
//                    List<ApplicationUser> approvers = appUserApproverList.stream()
//                            .map(appUserApprover -> applicationUserMap.get(appUserApprover.get_id()))
//                            .collect(Collectors.toList());
//                    appUsersGroup.setTransientApplicationUserApprover(approvers);
//                });
//
//        List<AppRole> appRoleList = getAppRoleList(appRoleReferenceListMap);
//
//        HashSet<Reference> moduleReferenceHashSet = new HashSet<>() ;
//        HashSet<Reference> menuReferenceHashSet = new HashSet<>() ;
//        HashSet<Reference> subMenuReferenceHashSet = new HashSet<>() ;
//        HashSet<Reference> tabReferenceHashSet = new HashSet<>() ;
//
//        HashSet<String> moduleReferenceIds = new HashSet<>() ;
//        HashSet<String> menuReferenceIds = new HashSet<>() ;
//        HashSet<String> subMenuReferenceIds = new HashSet<>() ;
//        HashSet<String> tabReferenceIds = new HashSet<>() ;
//
//        /*
//          From appRole list i am fetching the module , menu , submenu and template tab reference
//         */
//        appRoleList.stream()
//                .forEach(appRole -> {
//                    TreeMap<String, AppResourceModule> modules = appRole.getAppResourceList();
//
//                    for (Map.Entry<String, AppResourceModule> moduleEntry : modules.entrySet()) {
//                        AppResourceModule appModule = moduleEntry.getValue();
//                        Reference moduleReference = appModule.getReference();
//
//                        if (moduleReference != null && !moduleReferenceIds.contains(moduleReference.get_id())) {
//                            moduleReferenceHashSet.add(moduleReference);
//                            moduleReferenceIds.add(moduleReference.get_id());
//                        }
//
//                        TreeMap<String, AppResourceMenu> menus = appModule.getMenus();
//                        for (Map.Entry<String, AppResourceMenu> menuEntry : menus.entrySet()) {
//                            AppResourceMenu appMenu = menuEntry.getValue();
//                            Reference menuReference = appMenu.getReference();
//
//                            if (menuReference != null && !menuReferenceIds.contains(menuReference.get_id())) {
//                                menuReferenceHashSet.add(menuReference);
//                                menuReferenceIds.add(menuReference.get_id());
//                            }
//
//                            TreeMap<String, AppResourceMenu> subMenus = appMenu.getSubmenus();
//                            if (subMenus == null) {
//                                TreeMap<String, AppResourceTemplateTab> templateTabs = appMenu.getTemplateTabs();
//                                if (templateTabs != null) {
//                                    for (Map.Entry<String, AppResourceTemplateTab> templateTabEntry : templateTabs.entrySet()) {
//                                        AppResourceTemplateTab appTemplateTab = templateTabEntry.getValue();
//                                        Reference templateTabReference = appTemplateTab.getReference();
//
//                                        if (templateTabReference != null && !tabReferenceIds.contains(templateTabReference.get_id())) {
//                                            tabReferenceHashSet.add(templateTabReference);
//                                            tabReferenceIds.add(templateTabReference.get_id());
//                                        }
//                                    }
//                                }
//                            } else {
//                                for (Map.Entry<String, AppResourceMenu> subMenuEntry : subMenus.entrySet()) {
//                                    AppResourceMenu appSubMenu = subMenuEntry.getValue();
//                                    Reference subMenuReference = appSubMenu.getReference();
//
//                                    if (subMenuReference != null && !subMenuReferenceIds.contains(subMenuReference.get_id())) {
//                                        subMenuReferenceHashSet.add(subMenuReference);
//                                        subMenuReferenceIds.add(subMenuReference.get_id());
//                                    }
//
//                                    TreeMap<String, AppResourceTemplateTab> templateTabsForSubMenu = appSubMenu.getTemplateTabs();
//                                    if (templateTabsForSubMenu != null) {
//                                        for (Map.Entry<String, AppResourceTemplateTab> templateTabEntry : templateTabsForSubMenu.entrySet()) {
//                                            AppResourceTemplateTab appTemplateTab = templateTabEntry.getValue();
//                                            Reference templateTabReference = appTemplateTab.getReference();
//
//                                            if (templateTabReference != null && !tabReferenceIds.contains(templateTabReference.get_id())) {
//                                                tabReferenceHashSet.add(templateTabReference);
//                                                tabReferenceIds.add(templateTabReference.get_id());
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                });
//
//
//         /*
//           Fetching the module list from DB where module reference list provided
//         */
//        List<ProjectModules> projectModulesList = getProjectModulesList(moduleReferenceHashSet);
//
//        /*
//           Fetching the MenuList list from DB where Menu reference list provided
//        */
//        List<Menu> menuList = getMenuList(menuReferenceHashSet);
//
//        /*
//           Fetching the SubMenuList list from DB where SubMenuList reference list provided
//        */
//        List<Menu> menuListForSubMenu = collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(Menu.class)
//                .selectColumn(SelectColumn.builder().columns(List.of("submenu._id" , "submenu.name" , "submenu.label" , "submenu.index")).build())
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("submenu._id")
//                        .operator(Operator.IN)
//                        .value(subMenuReferenceHashSet
//                                .stream()
//                                .map(Reference::get_id)
//                                .collect(Collectors.toList()))
//                        .build()))
//                .build());
//
//        List<Menu> subMenuList = menuListForSubMenu
//                .stream()
//                .map(Menu::getSubmenu)
//                .flatMap(List::stream)
//                .distinct()
//                .collect(Collectors.toList());
//
//        /*
//           Fetching the TemplateList list from DB where tabReferenceHashSet provided
//        */
//        List<TemplateTab> templateList = collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(TemplateTab.class)
//                .excludeColumn(ExcludeColumn.builder().columns(List.of("api_params" ,
//                        "call_back_field" ,
//                        "migrationStatus" ,
//                        "altname" ,
//                        "form_reference" ,
//                        "grid_reference" ,
//                        "srNumber" ,
//                        "createdDate" ,
//                        "series",
//                        "createdByName",
//                        "updatedByName" ,
//                        "status" ,
//                        "forms.default.srNumber" ,
//                        "forms.default.createdDate" ,
//                        "forms.default.altname" ,
//                        "forms.default.createdByName" ,
//                        "forms.default.createdDate" ,
//                        "forms.default.updatedBy" ,
//                        "forms.default.updatedByName" ,
//                        "forms.default.updatedByName" ,
//                        "forms.default.updateDate" ,
//                        "forms.default.tab_list_buttons" ,
//                        "updatedBy" ,
//                        "updateDate" ,
//                        "version" ,
//                        "createdBy" )).build())
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("_id")
//                        .operator(Operator.IN)
//                        .value(tabReferenceHashSet
//                                .stream()
//                                .map(Reference::get_id)
//                                .collect(Collectors.toList()))
//                        .build()))
//                .build());
//
//        /*
//        Convert projectModulesList to projectModulesMap where key will be Id
//         */
//        Map<String, ProjectModules> projectModulesMap = projectModulesList.stream()
//                .collect(Collectors
//                        .toMap(ProjectModules::get_id , module -> module));
//
//        /*
//        Convert menuList to menuMap where key will be Id
//         */
//        Map<String,Menu> menuMap = menuList.stream()
//                .collect(Collectors
//                        .toMap(Menu::get_id ,menu -> menu)) ;
//
//        Map<String, Menu> subMenuMap = new HashMap<>();
//        for (Menu subMenu : subMenuList) {
//            if (subMenu.get_id() != null) {
//                subMenuMap.put(subMenu.get_id(), subMenu);
//            }
//        }
//
//        /*
//        Convert templateList to templateTabMap where key will be Id
//         */
//        Map<String,TemplateTab> templateTabMap = templateList.stream()
//                .collect(Collectors
//                        .toMap(TemplateTab::get_id , tab -> tab)) ;
//
//
//        /*
//        Populate ApplicationUser and AppUsersGroup and AppGroupOfGroup
//         */
//        appRoleBindingList.stream().forEach(appRoleBinding -> {
//            appRoleBinding.getAppRoleBindingSubjectList()
//                    .stream()
//                    .forEach(appRoleBindingSubject -> {
//                        if (appRoleBindingSubject.getAppApplicationUser() != null)
//                            populateTransientApplicationUserForRoleBindingSubject(applicationUserMap, appRoleBindingSubject);
//                        else if (appRoleBindingSubject.getAppUserGroup() != null) {
//                            populateTransiendAppUsersGroup(appUsersGroupMap, appApplicationUserList, appRoleBindingSubject);
//                        }
//                        else if (appRoleBindingSubject.getAppUserGroupOfGroup() != null) {
//                            populateTransientAppGroupOfGroupForAppRoleBindingSubject(appUsersGroupList, appGroupOfGroupMap, appApplicationUserList, appRoleBindingSubject);
//                        }
//                    });
//
//
//            List<String> roleReferences = appRoleBinding.getAppRoleList().stream().map(Reference::get_id).collect(Collectors.toList());
//            List<AppRole> appRoleListForRoleBinding = roleReferences.stream().map(roleReferenceId -> {
//                        return appRoleList.stream()
//                                .filter(appRole -> appRole.get_id().equals(roleReferenceId))
//                                .collect(Collectors.toList());
//                    })
//                    .flatMap(List::stream)
//                    .collect(Collectors.toList());
//            appRoleBinding.setTransientAppRole(appRoleListForRoleBinding);
//        });
//
//
//        /*
//         Maintaining a Map where I am maintaining usersGroup List, AppRole List ,AppGroupOfGroup List for all individual users ,
//         */
//        appApplicationUserList.stream().forEach(user -> {
//
//            UserMetaData userMetaData = getUserMetaData(user);
//
//            List<AppUsersGroup> userGroupList = getAppUsersGroups(appUsersGroupList, user);
//
//            List<AppGroupOfGroup> appGroupOfGroupList1 = getAppGroupOfGroups(appGroupOfGroupList, appUsersGroupList, user);
//
//            List<Reference> appRoleReferences = getAppRoleReferences(userid, appRoleBindingList, appGroupOfGroupList, appUsersGroupList);
//
//            List<AppRole> appRoles = getAppRoles(appRoleList, appRoleReferences);
//
//        });
//
//        Map<String, UserAndGroupAndGroupOfGroupAndAppRole> userAndGroupAndGroupOfGroupAndAppRoleHashMap = new HashMap<>();
//
//        /*
//            The Map contains keys that represent the individual users, and the corresponding values consist of lists containing information about usersGroup, AppRole,
//            and AppGroupOfGroup for each user. This allows for easy retrieval and storage of user-specific data for further processing or usage.
//         */
//        appRoleBindingList.stream()
//                .forEach(appRoleBinding -> {
//                    if (appRoleBinding != null && appRoleBinding.getAppRoleBindingSubjectList() != null) {
//                        appRoleBinding.getAppRoleBindingSubjectList().stream()
//                                .forEach(appRoleBindingSubject -> {
//                                    if (appRoleBindingSubject != null) {
//                                        HashSet<ApplicationUser> applicationUserHashSet = getApplicationUsersFromUsersGroupAndGroupOfGroup(appRoleBindingSubject , applicationUserMap);
//                                        if (applicationUserHashSet != null) {
//                                            applicationUserHashSet.stream()
//                                                    .forEach(applicationUser -> {
//                                                        if (applicationUser != null) {
//                                                            UserMetaData userMetaData1 = new UserMetaData();
//                                                            userMetaData1.setUserId(applicationUser.get_id());
//                                                            userMetaData1.setAppId(applicationUser.getAppId());
//                                                            userMetaData1.setRefCode(applicationUser.getRefCode());
//
//                                                            if (!userAndGroupAndGroupOfGroupAndAppRoleHashMap.containsKey(userMetaData1.getMetadata())) {
//                                                                UserAndGroupAndGroupOfGroupAndAppRole details = UserAndGroupAndGroupOfGroupAndAppRole.builder()
//                                                                        .user(applicationUser)
//                                                                        .appRole(new HashSet<>(appRoleBinding.getTransientAppRole()))
//                                                                        .appUsersGroup(new HashSet<>(Arrays.asList(appRoleBindingSubject.getTransientAppUsersGroup())))
//                                                                        .appGroupOfGroup(new HashSet<>(Arrays.asList(appRoleBindingSubject.getTransientAppGroupOfGroup())))
//                                                                        .build();
//                                                                userAndGroupAndGroupOfGroupAndAppRoleHashMap.put(userMetaData1.getMetadata(), details);
//                                                            } else {
//                                                                UserAndGroupAndGroupOfGroupAndAppRole details = userAndGroupAndGroupOfGroupAndAppRoleHashMap.get(userMetaData1.getMetadata());
//                                                                details.getAppRole().addAll(appRoleBinding.getTransientAppRole());
//                                                                details.getAppUsersGroup().add(appRoleBindingSubject.getTransientAppUsersGroup());
//                                                                details.getAppGroupOfGroup().add(appRoleBindingSubject.getTransientAppGroupOfGroup());
//                                                            }
//                                                        }
//                                                    });
//                                        }
//                                    }
//                                });
//                    }
//                });
//
//        /*
//        From existing Map fetching all assigned role for a individual users ; and preparing hierarchical structure response
//        And returning that response to utvn/v2 call response ;
//        */
//        try {
//            UserAndGroupAndGroupOfGroupAndAppRole userAndGroupAndGroupOfGroupAndAppRole = userAndGroupAndGroupOfGroupAndAppRoleHashMap
//                    .get(currentUser.getAppId()+"#"+currentUser.getRefCode()+"#"+userid);
//            HashSet<AppRole> appRoles = new HashSet<>() ;
//            appRoles = userAndGroupAndGroupOfGroupAndAppRole.getAppRole();
//            TreeMap<String, AppResourceModule> modules = new TreeMap<>();
//
//            HashSet<String> templateTabSet = new HashSet<>() ;
//            HashSet<String> moduleSet = new HashSet<>() ;
//
//            for ( AppRole appRole : appRoles){
//                TreeMap<String, AppResourceModule> appResourceModuleTreeMap = appRole.getAppResourceList() ;
//                for ( Map.Entry<String, AppResourceModule> moduleEntry : appResourceModuleTreeMap.entrySet()) {
//                    AppResourceModule appResourceModule = moduleEntry.getValue();
//                    Reference moduleReference = appResourceModule.getReference();
//                    if ( moduleReference != null && moduleReference.isAllSelected()){
//                        moduleSet.add(moduleReference.get_id()) ;
//                        addAllMenusForModule( moduleReference ,modules , templateTabSet , menuMap , projectModulesMap , templateMap , templateTabMap , appRole.getAppActionsList()) ;
//                    }
//                    TreeMap<String, AppResourceMenu> appResourceMenuTreeMap = appResourceModule.getMenus();
//                    ProjectModules projectModules = projectModulesMap.get(moduleReference.get_id());
//                    if (projectModules != null && projectModules.getName() != null) {
//                        String moduleName = projectModules.getName();
//
//                        if (!modules.containsKey(moduleName)) {
//
//                            AppResourceModule appResourceModule1 = new AppResourceModule();
//                            appResourceModule1.setReference(null);
//                            appResourceModule1.setMenus(null);
//                            appResourceModule1.setDetails(projectModules);
//
//                            TreeMap<String, AppResourceMenu> appResourceMenuTreeMap1 = new TreeMap<>();
//
//                            for (Map.Entry<String, AppResourceMenu> menuEntry : appResourceMenuTreeMap.entrySet()) {
//                                AppResourceMenu appResourceMenu = menuEntry.getValue();
//                                Reference menuReference = appResourceMenu.getReference();
//
//                                TreeMap<String, AppResourceMenu> appResourceSubMenuTreeMap = appResourceMenu.getSubmenus();
//                                TreeMap<String, AppResourceTemplateTab> appTemplatetabTreeMap = appResourceMenu.getTemplateTabs();
//
//                                Menu menu = menuMap.get(menuReference.get_id());
//                                if (menu != null) {
//                                    AppResourceMenu appResourceMenu1 = new AppResourceMenu();
//                                    appResourceMenu1.setReference(null);
//                                    appResourceMenu1.setSubmenus(null);
//                                    appResourceMenu1.setTemplateTabs(null);
//                                    appResourceMenu1.setDetails(menu);
//
//                                    if (appResourceMenu.getSubmenus() == null) {
//                                        appResourceMenu1.setSubmenuMap(null);
//
//                                        TreeMap<String, AppResourceTemplateTab> appResourceTemplateTabTreeMap = new TreeMap<>();
//                                        for (Map.Entry<String, AppResourceTemplateTab> templateTabEntry : appTemplatetabTreeMap.entrySet()) {
//                                            AppResourceTemplateTab appResourceTemplateTab = templateTabEntry.getValue();
//                                            Reference templateTabReference = appResourceTemplateTab.getReference();
//                                            TemplateTab templateTab = templateTabMap.get(templateTabReference.get_id());
//                                            if (templateTabReference.get_id() != null) {
//                                                templateTabSet.add(templateTabReference.get_id());
//                                            }
//                                            AppResourceTemplateTab appResourceTemplateTab1 = new AppResourceTemplateTab();
//                                            if (templateTab != null && templateTab.getName() != null) {
//                                                String templateTabName = templateTab.getTab_name();
//                                                appResourceTemplateTab1.setDetails(null);
//                                                appResourceTemplateTab1.setAccess(AppActions.actions(appRole.getAppActionsList()));
//                                                appResourceTemplateTabTreeMap.put(templateTabName, appResourceTemplateTab1);
//                                            }
//                                        }
//                                        appResourceMenu1.setTemplateTabMap(appResourceTemplateTabTreeMap);
//                                    } else {
//                                        appResourceMenu1.setTemplateTabs(null);
//                                        TreeMap<String, AppResourceMenu> appResourceSubMenuTreeMap1 = new TreeMap<>();
//                                        for (Map.Entry<String, AppResourceMenu> subMenuEntry : appResourceSubMenuTreeMap.entrySet()) {
//                                            AppResourceMenu appResourceSubMenu = subMenuEntry.getValue();
//                                            Reference subMenuReference = appResourceSubMenu.getReference();
//                                            Menu submenu = subMenuMap.get(subMenuReference.get_id());
//                                            if (submenu != null) {
//                                                AppResourceMenu appResourceSubMenu2 = new AppResourceMenu();
//                                                appResourceSubMenu2.setReference(null);
//                                                appResourceSubMenu2.setTemplateTabs(null);
//                                                appResourceSubMenu2.setSubmenus(null);
//                                                appResourceSubMenu2.setSubmenuMap(null);
//                                                appResourceSubMenu2.setDetails(submenu);
//
//                                                TreeMap<String, AppResourceTemplateTab> appResourceTemplateTabTreeMap1 = appResourceSubMenu.getTemplateTabs();
//
//                                                TreeMap<String, AppResourceTemplateTab> appResourceTemplateTabTreeMap = new TreeMap<>();
//
//                                                for (Map.Entry<String, AppResourceTemplateTab> templateTabEntry : appResourceTemplateTabTreeMap1.entrySet()) {
//                                                    AppResourceTemplateTab appResourceTemplateTab = templateTabEntry.getValue();
//                                                    Reference templateTabReference = appResourceTemplateTab.getReference();
//                                                    TemplateTab templateTab = templateTabMap.get(templateTabReference.get_id());
//                                                    if (templateTabReference.get_id() != null) {
//                                                        templateTabSet.add(templateTabReference.get_id());
//                                                    }
//                                                    AppResourceTemplateTab appResourceTemplateTab1 = new AppResourceTemplateTab();
//                                                    appResourceTemplateTab1.setDetails(null);
//                                                    if (templateTab != null && templateTab.getName() != null) {
//                                                        String templateTabName = templateTab.getTab_name();
//                                                        appResourceTemplateTab1.setDetails(null);
//                                                        appResourceTemplateTab1.setAccess(AppActions.actions(appRole.getAppActionsList()));
//                                                        appResourceTemplateTabTreeMap.put(templateTabName, appResourceTemplateTab1);
//                                                    }
//                                                }
//                                                appResourceSubMenu2.setTemplateTabMap(appResourceTemplateTabTreeMap);
//                                                if (appResourceSubMenu2.getDetails() != null && appResourceSubMenu2.getDetails().getName() != null) {
//                                                    appResourceSubMenuTreeMap1.put(appResourceSubMenu2.getDetails().getName(), appResourceSubMenu2);
//                                                }
//                                            }
//                                        }
//                                        appResourceMenu1.setSubmenuMap(appResourceSubMenuTreeMap1);
//                                    }
//                                    if (appResourceMenu1.getDetails() != null && appResourceMenu1.getDetails().getName() != null) {
//                                        appResourceMenuTreeMap1.put(appResourceMenu1.getDetails().getName(), appResourceMenu1);
//                                    }
//                                }
//                            }
//                            appResourceModule1.setMenuMap(appResourceMenuTreeMap1);
//                            if (appResourceModule1.getDetails() != null && appResourceModule1.getDetails().getName() != null) {
//                                modules.put(appResourceModule1.getDetails().getName(), appResourceModule1);
//                                moduleSet.add(appResourceModule1.getDetails().get_id());
//                            }
//                        } else {
//                            AppResourceModule appResourceModule1 = modules.get(moduleName);
//                            if (appResourceModule1 != null) {
//                                TreeMap<String, AppResourceMenu> appResourceMenuTreeMap1 = appResourceModule1.getMenuMap();
//                                if (appResourceMenuTreeMap != null) {
//                                    for (Map.Entry<String, AppResourceMenu> menuEntry : appResourceMenuTreeMap.entrySet()) {
//                                        AppResourceMenu appResourceMenu = menuEntry.getValue();
//                                        Reference menuReference = appResourceMenu.getReference();
//
//                                        TreeMap<String, AppResourceMenu> appResourceSubMenuTreeMap = appResourceMenu.getSubmenus();
//                                        TreeMap<String, AppResourceTemplateTab> appTemplatetabTreeMap = appResourceMenu.getTemplateTabs();
//
//                                        Menu menu = menuMap.get(menuReference.get_id());
//                                        if (menu != null) {
//
//                                            AppResourceMenu appResourceMenu1;
//                                            if (!appResourceMenuTreeMap1.containsKey(menu.getName())) {
//                                                appResourceMenu1 = new AppResourceMenu();
//                                            } else {
//                                                appResourceMenu1 = appResourceMenuTreeMap1.get(menu.getName());
//                                            }
//
//                                            appResourceMenu1.setReference(null);
//                                            appResourceMenu1.setSubmenus(null);
//                                            appResourceMenu1.setTemplateTabs(null);
//                                            appResourceMenu1.setDetails(menu);
//
//                                            if (appResourceMenu.getSubmenus() == null) {
//                                                appResourceMenu1.setSubmenuMap(null);
//
//                                                TreeMap<String, AppResourceTemplateTab> appResourceTemplateTabTreeMap;
//                                                if (appResourceMenu1.getTemplateTabMap() != null && appResourceMenu1.getTemplateTabMap().size() > 0) {
//                                                    appResourceTemplateTabTreeMap = appResourceMenu1.getTemplateTabMap();
//                                                } else {
//                                                    appResourceTemplateTabTreeMap = new TreeMap<>();
//                                                }
//
//                                                for (Map.Entry<String, AppResourceTemplateTab> templateTabEntry : appTemplatetabTreeMap.entrySet()) {
//                                                    AppResourceTemplateTab appResourceTemplateTab = templateTabEntry.getValue();
//                                                    Reference templateTabReference = appResourceTemplateTab.getReference();
//                                                    TemplateTab templateTab = templateTabMap.get(templateTabReference.get_id());
//                                                    if (templateTabReference.get_id() != null) {
//                                                        templateTabSet.add(templateTabReference.get_id());
//                                                    }
//                                                    AppResourceTemplateTab appResourceTemplateTab1 = new AppResourceTemplateTab();
//                                                    if (templateTab != null && templateTab.getName() != null) {
//                                                        String templateTabName = templateTab.getTab_name();
//                                                        appResourceTemplateTab1.setDetails(null);
//                                                        appResourceTemplateTab1.setAccess(AppActions.actions(appRole.getAppActionsList()));
//                                                        if (!appResourceTemplateTabTreeMap.containsKey(templateTabName)) {
//                                                            appResourceTemplateTabTreeMap.put(templateTabName, appResourceTemplateTab1);
//                                                        } else {
//                                                            AppResourceTemplateTab existingTemplateTab = appResourceTemplateTabTreeMap.get(templateTabName);
//                                                            List<AppActions> appActions = existingTemplateTab.getAccess();
//                                                            List<AppActions> newAppActions = AppActions.actions(appRole.getAppActionsList());
//                                                            List<AppActions> uniqueActionList = getUniqueAcctionList(appActions, newAppActions);
//                                                            appResourceTemplateTab1.setAccess(uniqueActionList);
//                                                            appResourceTemplateTabTreeMap.put(templateTabName, appResourceTemplateTab1);
//                                                        }
//                                                    }
//                                                }
//                                                appResourceMenu1.setTemplateTabMap(appResourceTemplateTabTreeMap);
//                                            } else {
//                                                appResourceMenu1.setTemplateTabs(null);
//
//                                                TreeMap<String, AppResourceMenu> appResourceSubMenuTreeMap1 = appResourceMenu1.getSubmenuMap();
//                                                if (appResourceSubMenuTreeMap1 == null) {
//                                                    appResourceSubMenuTreeMap1 = new TreeMap<>();
//                                                }
//
//                                                for (Map.Entry<String, AppResourceMenu> subMenuEntry : appResourceSubMenuTreeMap.entrySet()) {
//                                                    AppResourceMenu appResourceSubMenu = subMenuEntry.getValue();
//                                                    Reference subMenuReference = appResourceSubMenu.getReference();
//                                                    Menu Submenu = subMenuMap.get(subMenuReference.get_id());
//
//                                                    AppResourceMenu appResourceSubMenu2;
//                                                    if (appResourceSubMenuTreeMap1 == null || !appResourceSubMenuTreeMap1.containsKey(Submenu.getName())) {
//                                                        appResourceSubMenu2 = new AppResourceMenu();
//                                                    } else {
//                                                        appResourceSubMenu2 = appResourceSubMenuTreeMap1.get(Submenu.getName());
//                                                    }
//                                                    appResourceSubMenu2.setReference(null);
//                                                    appResourceSubMenu2.setTemplateTabs(null);
//                                                    appResourceSubMenu2.setSubmenus(null);
//                                                    appResourceSubMenu2.setSubmenuMap(null);
//                                                    appResourceSubMenu2.setDetails(Submenu);
//
//                                                    TreeMap<String, AppResourceTemplateTab> appResourceTemplateTabTreeMap1 = appResourceSubMenu.getTemplateTabs();
//
//                                                    TreeMap<String, AppResourceTemplateTab> appResourceTemplateTabTreeMap;
//                                                    if (appResourceSubMenu2.getTemplateTabMap() != null && appResourceSubMenu2.getTemplateTabMap().size() > 0) {
//                                                        appResourceTemplateTabTreeMap = appResourceSubMenu2.getTemplateTabMap();
//                                                    } else {
//                                                        appResourceTemplateTabTreeMap = new TreeMap<>();
//                                                    }
//
//                                                    for (Map.Entry<String, AppResourceTemplateTab> templateTabEntry : appResourceTemplateTabTreeMap1.entrySet()) {
//                                                        AppResourceTemplateTab appResourceTemplateTab = templateTabEntry.getValue();
//                                                        Reference templateTabReference = appResourceTemplateTab.getReference();
//                                                        TemplateTab templateTab = templateTabMap.get(templateTabReference.get_id());
//                                                        if (templateTabReference.get_id() != null) {
//                                                            templateTabSet.add(templateTabReference.get_id());
//                                                        }
//                                                        AppResourceTemplateTab appResourceTemplateTab1 = new AppResourceTemplateTab();
//
//                                                        if (templateTab != null && templateTab.getName() != null) {
//                                                            String templateTabName = templateTab.getTab_name();
//                                                            appResourceTemplateTab1.setDetails(null);
//                                                            appResourceTemplateTab1.setAccess(AppActions.actions(appRole.getAppActionsList()));
//                                                            if (!appResourceTemplateTabTreeMap.containsKey(templateTabName)) {
//                                                                appResourceTemplateTabTreeMap.put(templateTabName, appResourceTemplateTab1);
//                                                            } else {
//                                                                AppResourceTemplateTab existingTemplateTab = appResourceTemplateTabTreeMap.get(templateTabName);
//                                                                List<AppActions> appActions = existingTemplateTab.getAccess();
//                                                                List<AppActions> newAppActions = AppActions.actions(appRole.getAppActionsList());
//                                                                List<AppActions> uniqueActionList = getUniqueAcctionList(appActions, newAppActions);
//                                                                appResourceTemplateTab1.setAccess(uniqueActionList);
//                                                                appResourceTemplateTabTreeMap.put(templateTabName, appResourceTemplateTab1);
//                                                            }
//                                                        }
//                                                    }
//                                                    appResourceSubMenu2.setTemplateTabMap(appResourceTemplateTabTreeMap);
//                                                    if (appResourceSubMenu2.getDetails() != null && appResourceSubMenu2.getDetails().getName() != null) {
//                                                        appResourceSubMenuTreeMap1.put(appResourceSubMenu2.getDetails().getName(), appResourceSubMenu2);
//                                                    }
//                                                }
//                                                appResourceMenu1.setSubmenuMap(appResourceSubMenuTreeMap1);
//                                            }
//                                            if (appResourceMenu1.getDetails() != null && appResourceMenu1.getDetails().getName() != null) {
//                                                appResourceMenuTreeMap1.put(appResourceMenu1.getDetails().getName(), appResourceMenu1);
//                                            }
//                                        }
//                                    }
//                                    appResourceModule1.setMenuMap(appResourceMenuTreeMap1);
//                                    if (appResourceModule1.getDetails() != null && appResourceModule1.getDetails().getName() != null) {
//                                        modules.put(appResourceModule1.getDetails().getName(), appResourceModule1);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            userIdAndTemplateTabIdSetMap.put(userid,templateTabSet);
//            userIdAndModuleIdSetMap.put(userid,moduleSet);
//            return modules ;
//
//        } catch (Exception e ){
//            e.printStackTrace();
//            throw new NotFoundException(ExceptionTrace.builder()
//                    .errorMessage("User do not have any permission")
//                    .exceptionDate(new Date())
//                    .action("Get Permission List")
//                    .build());
//        }
//    }
//
//    private void addAllMenusForModule(Reference moduleReference, TreeMap<String, AppResourceModule> modules,
//                                      HashSet<String> templateTabSet, Map<String, Menu> menuMap, Map<String,
//            ProjectModules> projectModulesMap, Map<String, Template> templateMap,
//                                      Map<String, TemplateTab> templateTabMap , List<AppActions> appActionsList ) {
//        ProjectModules projectModules = projectModulesMap.get(moduleReference.get_id()) ;
//        if (projectModules != null && projectModules.getName() != null){
//            String moduleName = projectModules.getName() ;
//            if ( modules.containsKey(moduleName)){
//
//            } else {
//
//            }
//        }
//    }
//
//    private List<AppActions> getUniqueAcctionList(List<AppActions> appActions, List<AppActions> newAppActions) {
//        HashSet<AppActions> actionsHashSet = new HashSet<>() ;
//        for ( AppActions appActions1 : appActions ){
//            actionsHashSet.add(appActions1) ;
//        }
//        for ( AppActions appActions1 : newAppActions ){
//            actionsHashSet.add(appActions1) ;
//        }
//        return new ArrayList<>(actionsHashSet) ;
//    }
//
//    public List getMenuList(HashSet<Reference> menuReferenceHashSet) {
//        return collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(Menu.class)
//                .selectColumn(SelectColumn.builder()
//                        .columns(List.of("_id", "name", "label" , "index"))
//                        .build())
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("_id")
//                        .operator(Operator.IN)
//                        .value(menuReferenceHashSet
//                                .stream()
//                                .map(Reference::get_id)
//                                .collect(Collectors.toList()))
//                        .build()))
//                .build());
//    }
//
//    private static void addModule(TreeMap<String, AppModule> modules, App_Resource appResource, String moduleName, AppMenu appMenu) {
//        AppModule appModule = new AppModule();
//        appModule.setDetails(appResource.getTransientModule());
//        TreeMap<String, AppMenu> menus = new TreeMap<>();
//        menus.put(appMenu.getDetails().getName(), appMenu);
//        appModule.setMenus(menus);
//
//        modules.put(moduleName, appModule);
//    }
//
//    private static void addTemplateTabInMenu(App_Resource appResource, AppTemplateTab appTemplateTab, AppMenu appMenu) {
//        TreeMap<String, AppTemplateTab> templateTabs = new TreeMap<>();
//        if (appResource.getTransientTemplateTab() != null) {
////            templateTabs.put(appTemplateTab.getDetails().getTab_name(), appTemplateTab);
//            templateTabs.put(appResource.getTransientTemplateTab().getTab_name(), appTemplateTab);
//        }
//        appMenu.setTemplateTabs(templateTabs);
//    }
//
//    private static AppMenu getSubMenu(App_Resource appResource, AppTemplateTab appTemplateTab) {
//        AppMenu appSubMenu = new AppMenu();
//        appSubMenu.setDetails(appResource.getTransientSubMenu());
//        addTemplateTabInMenu(appResource, appTemplateTab, appSubMenu);
//
//        return appSubMenu;
//    }
//
//    @NotNull
//    public AppTemplateTab getAppTemplateTab(AppTemplateTab appTemplateTab, App_Resource appResource) {
//        if(appTemplateTab == null)
//            appTemplateTab = new AppTemplateTab();
//
//        appTemplateTab.setDetails(appResource.getTransientTemplateTab());
//        List<AppActions> access = new ArrayList<>() ;
//        if (appResource.isAdd()) {
//            access.add(AppActions.ADD) ;
//        }
//        if (appResource.isEdit()) {
//            access.add(AppActions.EDIT) ;
//        }
//        if (appResource.isView()) {
//            access.add(AppActions.VIEW) ;
//        }
//        if (appResource.isDelete()) {
//            access.add(AppActions.DELETE) ;
//        }
//        if (appResource.isActive()) {
//            access.add(AppActions.ACTIVE) ;
//        }
//        if (appResource.isExport()) {
//            access.add(AppActions.EXPORT) ;
//        }
//        if (appResource.isAuditHistory()) {
//            access.add(AppActions.AUDIT_HISTORY) ;
//        }
//        appTemplateTab.setAccess(access);
//        return appTemplateTab;
//    }
//
//    private List getProjectModulesList(HashSet<Reference> moduleReferenceHashSet) {
//        return collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(ProjectModules.class)
//                .selectColumn(SelectColumn.builder()
//                        .columns(List.of("_id","name","title" ,"imgPath" ,"menu_list" , "mouseHover" , "description"))
//                        .build())
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("_id")
//                        .operator(Operator.IN)
//                        .value(moduleReferenceHashSet
//                                .stream()
//                                .map(Reference::get_id)
//                                .collect(Collectors.toList()))
//                        .build()))
//                .build());
//    }
//
//    private List<AppRole> getAppRoleList(Map<String, List<Reference>> appRoleReferenceListMap) {
//        List<String> roleIds = appRoleReferenceListMap.entrySet().stream()
//                .map(Map.Entry::getValue)
//                .flatMap(List::stream)
//                .distinct()
//                .map(Reference::get_id)
//                .collect(Collectors.toList());
//
//        return collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(AppRole.class)
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("_id")
//                        .operator(Operator.IN)
//                        .value(roleIds)
//                        .build()))
//                .build());
//    }
//    public UserMetaData getUserMetaData(ApplicationUser user) {
//        return UserMetaData.builder()
//                .userId(user.get_id())
//                .appId(user.getAppId())
//                .refCode(user.getRefCode())
//                .build();
//    }
//
//    @NotNull
//    public HashSet<ApplicationUser> getApplicationUsersFromUsersGroupAndGroupOfGroup(AppRoleBindingSubject appRoleBindingSubject , Map<String,ApplicationUser> applicationUserMap) {
//        HashSet<ApplicationUser> applicationUserHashSet = new HashSet<>();
//
//        if (appRoleBindingSubject.getAppApplicationUser() != null) {
//            ApplicationUser applicationUser = appRoleBindingSubject.getTransientApplicationUser();
//            if (applicationUser != null) {
//                applicationUserHashSet.add(applicationUser);
//            }
//        } else if (appRoleBindingSubject.getAppUserGroup() != null) {
//            AppUsersGroup appUsersGroup = appRoleBindingSubject.getTransientAppUsersGroup();
//            if (appUsersGroup != null) {
//                List<ApplicationUser> applicationUsersFromAppUsersGroup = appUsersGroup.getTransientApplicationUser();
//                if (applicationUsersFromAppUsersGroup != null) {
//                    applicationUserHashSet.addAll(applicationUsersFromAppUsersGroup);
//                }
//            }
//        } else {
//            AppGroupOfGroup appGroupOfGroup = appRoleBindingSubject.getTransientAppGroupOfGroup();
//            if (appGroupOfGroup != null) {
//                List<AppUsersGroup> appUsersGroupList1 = appGroupOfGroup.getTransientAppUsersGroup();
//                List<Reference> applicationUserList = appGroupOfGroup.getAppUser() ;
//                if ( applicationUserList != null && applicationUserList.size() > 0 ){
//                    for ( Reference reference : applicationUserList ){
//                        ApplicationUser applicationUser = applicationUserMap.get(reference.get_id()) ;
//                        if ( applicationUser != null ){
//                            applicationUserHashSet.add(applicationUser) ;
//                        }
//                    }
//                }
//                if (appUsersGroupList1 != null) {
//                    appUsersGroupList1.stream()
//                            .filter(appUsersGroup1 -> appUsersGroup1.getTransientApplicationUser() != null)
//                            .flatMap(appUsersGroup1 -> appUsersGroup1.getTransientApplicationUser().stream())
//                            .forEach(applicationUserHashSet::add);
//                }
//            }
//        }
//
//        return applicationUserHashSet;
//
//    }
//
//    @NotNull
//    public List<AppUsersGroup> getAppUsersGroups(List<AppUsersGroup> appUsersGroupList, ApplicationUser user) {
//        List<AppUsersGroup> filteredAppUsersGroups = appUsersGroupList.stream()
//                .filter(appUsersGroup -> {
//                    if (appUsersGroup.getAppUser() != null) {
//                        long count = appUsersGroup.getAppUser().stream()
//                                .map(Reference::get_id)
//                                .filter(userId -> userId != null && userId.equals(user.get_id()))
//                                .count();
//                        return count > 0;
//                    }
//                    return false;
//                })
//                .collect(Collectors.toList());
//        return filteredAppUsersGroups ;
//    }
//
//    @NotNull
//    public List<AppRole> getAppRoles(List<AppRole> appRoleList, List<Reference> appRoleReferences) {
//        return appRoleList.stream()
//                .filter(appRole -> appRoleReferences.stream().map(Reference::get_id).anyMatch(roleRefId -> roleRefId.equals(appRole.get_id())))
//                .collect(Collectors.toList());
//    }
//
//    @NotNull
//    public List<Reference> getAppRoleReferences(String userid, List<AppRoleBinding> appRoleBindingList, List<AppGroupOfGroup> appGroupOfGroupList, List<AppUsersGroup> appUsersGroupList) {
//        return appRoleBindingList.stream()
//                .filter(appRoleBinding -> {
//                    if (appRoleBinding.getAppRoleBindingSubjectList() != null) {
//                        return appRoleBinding.getAppRoleBindingSubjectList().stream().filter(appRoleBindingSubject -> {
//                            Reference referenceAppUser = appRoleBindingSubject.getAppApplicationUser();
//                            Reference referenceAppGroup = appRoleBindingSubject.getAppUserGroup();
//                            Reference referenceAppUserGroupOfGroup = appRoleBindingSubject.getAppUserGroupOfGroup();
//                            return (referenceAppUser != null && referenceAppUser.get_id().equals(userid)) ||
//                                    (referenceAppGroup != null && appUsersGroupList.stream().anyMatch(group -> group.get_id().equals(referenceAppGroup.get_id()))) ||
//                                    (referenceAppGroup != null && appGroupOfGroupList.stream().anyMatch(groupOfGroup -> groupOfGroup.get_id().equals(referenceAppUserGroupOfGroup.get_id())));
//                        }).count() > 0;
//                    }
//                    return false;
//                })
//                .map(AppRoleBinding::getAppRoleList)
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//    }
//
//    public void populateTransientAppGroupOfGroupForAppRoleBindingSubject(List<AppUsersGroup> appUsersGroupList, Map<String, AppGroupOfGroup> appGroupOfGroupMap, List<ApplicationUser> appApplicationUserList, AppRoleBindingSubject appRoleBindingSubject) {
//        if (appRoleBindingSubject != null && appRoleBindingSubject.getAppUserGroupOfGroup() != null) {
//            String appUserGroupOfGroupId = appRoleBindingSubject.getAppUserGroupOfGroup().get_id();
//            if (appGroupOfGroupMap != null && appUserGroupOfGroupId != null) {
//                appRoleBindingSubject.setTransientAppGroupOfGroup(appGroupOfGroupMap.get(appUserGroupOfGroupId));
//                AppGroupOfGroup appGroupOfGroup = appRoleBindingSubject.getTransientAppGroupOfGroup();
//                if (appGroupOfGroup != null && appGroupOfGroup.getAppGroupList() != null && appUsersGroupList != null) {
//                    List<AppUsersGroup> appUsersGroups = appGroupOfGroup.getAppGroupList().stream()
//                            .flatMap(reference -> appUsersGroupList.stream().filter(group -> reference.get_id().equals(group.get_id())))
//                            .distinct()
//                            .collect(Collectors.toList());
//                    appGroupOfGroup.setTransientAppUsersGroup(appUsersGroups);
//
//                    appUsersGroups.forEach(usersGroup -> {
//                        if (usersGroup.getAppUser() != null && appApplicationUserList != null) {
//                            List<ApplicationUser> applicationUsers = usersGroup.getAppUser()
//                                    .stream()
//                                    .flatMap(reference -> appApplicationUserList.stream().filter(user -> reference.get_id().equals(user.get_id())))
//                                    .distinct()
//                                    .collect(Collectors.toList());
//                            usersGroup.setTransientApplicationUser(applicationUsers);
//                        }
//                    });
//                }
//            }
//        }
//
//    }
//
//    public void populateTransiendAppUsersGroup(Map<String, AppUsersGroup> appUsersGroupMap, List<ApplicationUser> appApplicationUserList, AppRoleBindingSubject appRoleBindingSubject) {
//        if (appRoleBindingSubject != null && appRoleBindingSubject.getAppUserGroup() != null) {
//            String appUserGroupId = appRoleBindingSubject.getAppUserGroup().get_id();
//            if (appUsersGroupMap != null && appUserGroupId != null) {
//                appRoleBindingSubject.setTransientAppUsersGroup(appUsersGroupMap.get(appUserGroupId));
//                AppUsersGroup appUsersGroup = appRoleBindingSubject.getTransientAppUsersGroup();
//                if (appUsersGroup != null && appUsersGroup.getAppUser() != null && appApplicationUserList != null) {
//                    List<ApplicationUser> applicationUserForAGroup = appUsersGroup.getAppUser().stream()
//                            .flatMap(reference -> appApplicationUserList.stream().filter(user -> reference.get_id().equals(user.get_id())))
//                            .distinct()
//                            .collect(Collectors.toList());
//                    appUsersGroup.setTransientApplicationUser(applicationUserForAGroup);
//                }
//            }
//        }
//    }
//
//    public void populateTransientApplicationUserForRoleBindingSubject(Map<String, ApplicationUser> applicationUserMap, AppRoleBindingSubject appRoleBindingSubject) {
//        if (appRoleBindingSubject != null && appRoleBindingSubject.getAppApplicationUser() != null) {
//            String appApplicationUserId = appRoleBindingSubject.getAppApplicationUser().get_id();
//            if (applicationUserMap != null && appApplicationUserId != null) {
//                appRoleBindingSubject.setTransientApplicationUser(applicationUserMap.get(appApplicationUserId));
//            }
//        }
//    }
//
//    public void populateApplicationUserReferencesAndUserGroupsReferencesAndGroupOfGroupReferences(List<Reference> applicationUserReferenceList,
//                                                                                                  List<Reference> appUsersGroupReferenceList,
//                                                                                                  List<Reference> appGroupOfGroupReferenceList,
//                                                                                                  Map<String, List<AppRoleBindingSubject>> appRoleBindingSubjectMap,
//                                                                                                  Map<String, List<Reference>> appRoleListMap,
//                                                                                                  List<AppRoleBinding> appRoleBindingList) {
//        appRoleBindingList.stream().forEach(appRoleBinding -> {
//            if (appRoleBinding != null) {
//                if (appRoleBinding.getAppRoleBindingSubjectList() != null) {
//                    appRoleBindingSubjectMap.put(appRoleBinding.getName(), appRoleBinding.getAppRoleBindingSubjectList());
//                    appRoleListMap.put(appRoleBinding.getName(), appRoleBinding.getAppRoleList());
//                    appRoleBinding.getAppRoleBindingSubjectList()
//                            .stream()
//                            .forEach(appRoleBindingSubject -> {
//                                if (appRoleBindingSubject != null) {
//                                    if (appRoleBindingSubject.getAppApplicationUser() != null)
//                                        applicationUserReferenceList.add(appRoleBindingSubject.getAppApplicationUser());
//                                    else if (appRoleBindingSubject.getAppUserGroup() != null)
//                                        appUsersGroupReferenceList.add(appRoleBindingSubject.getAppUserGroup());
//                                    else if (appRoleBindingSubject.getAppUserGroupOfGroup() != null)
//                                        appGroupOfGroupReferenceList.add(appRoleBindingSubject.getAppUserGroupOfGroup());
//                                }
//                            });
//                }
//            }
//        });
//    }
//
//    @NotNull
//    public List<AppGroupOfGroup> getAppGroupOfGroups(List<AppGroupOfGroup> appGroupOfGroupList, List<AppUsersGroup> appUsersGroupList, ApplicationUser user) {
//        return appGroupOfGroupList
//                .stream()
//                .filter(appGroupOfGroup -> appGroupOfGroup.getAppGroupList() != null && !appGroupOfGroup.getAppGroupList().isEmpty())
//                .filter(appGroupOfGroup ->
//                        appGroupOfGroup.getAppGroupList()
//                                .stream()
//                                .map(Reference::get_id)
//                                .filter(groupId -> groupId != null && appUsersGroupList != null && !appUsersGroupList.isEmpty())
//                                .filter(groupId ->
//                                        appUsersGroupList
//                                                .stream()
//                                                .filter(appUsersGroup -> appUsersGroup != null && appUsersGroup.get_id() != null && appUsersGroup.get_id().equals(groupId))
//                                                .filter(filteredGroup -> filteredGroup != null && filteredGroup.getAppUser() != null && !filteredGroup.getAppUser().isEmpty())
//                                                .filter(filteredGroup ->
//                                                        filteredGroup.getAppUser()
//                                                                .stream()
//                                                                .map(Reference::get_id)
//                                                                .filter(userId -> userId != null && userId.equals(user.get_id()))
//                                                                .count() > 0)
//                                                .count() > 0)
//                                .count() > 0)
//                .collect(Collectors.toList());
//
//    }
//
//    public List<ApplicationUser> getAppApplicationUserList(List<Reference> applicationUserReferenceList, List<AppGroupOfGroup> appGroupOfGroupList, List<AppUsersGroup> appUsersGroupList) {
//
//        List<String> userIds = new ArrayList<>();
//
//        userIds.addAll(applicationUserReferenceList.stream()
//                .map(Reference::get_id)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toSet()));
//        if ( appUsersGroupList != null && appUsersGroupList.size() > 0 ){
//            userIds.addAll(appUsersGroupList.stream()
//                    .map(AppUsersGroup::getAppUser)
//                    .filter(Objects::nonNull)
//                    .flatMap(List::stream)
//                    .map(Reference::get_id)
//                    .filter(Objects::nonNull)
//                    .collect(Collectors.toSet()));
//        }
//
//        if ( appGroupOfGroupList != null && appGroupOfGroupList.size() > 0 ){
//            for (AppGroupOfGroup appGroupOfGroup : appGroupOfGroupList) {
//                List<Reference> appGroupList = appGroupOfGroup.getAppGroupList();
//                List<Reference> appUsers = appGroupOfGroup.getAppUser();
//
//                if (appUsers != null && !appUsers.isEmpty()) {
//                    userIds.addAll(appUsers.stream()
//                            .map(Reference::get_id)
//                            .toList());
//                }
//
//                for (Reference reference : appGroupList) {
//                    List<AppUsersGroup> filteredAppUsersGroups = appUsersGroupList.stream()
//                            .filter(appUsersGroup -> Objects.equals(appUsersGroup.get_id(), reference.get_id()))
//                            .collect(Collectors.toList());
//
//                    for (AppUsersGroup appUsersGroup : filteredAppUsersGroups) {
//                        List<Reference> appUserList = appUsersGroup.getAppUser();
//                        if (appUserList != null) {
//                            userIds.addAll(appUserList.stream()
//                                    .map(Reference::get_id)
//                                    .filter(Objects::nonNull)
//                                    .collect(Collectors.toSet()));
//                        }
//                    }
//                }
//            }
//        }
//
//        List<ApplicationUser> applicationUsers =  collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(ApplicationUser.class)
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("_id")
//                        .operator(Operator.IN)
//                        .value(userIds)
//                        .build()))
//                .build());
//
//        return applicationUsers ;
//    }
//
//    public List getUsersGroupList(List<Reference> appUsersGroupReferenceList, List<AppGroupOfGroup> appGroupOfGroupList) {
//        return collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(AppUsersGroup.class)
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("_id")
//                        .operator(Operator.IN)
//                        .value(Stream.concat(appUsersGroupReferenceList.stream()
//                                                        .map(Reference::get_id),
//                                                appGroupOfGroupList.stream()
//                                                        .map(AppGroupOfGroup::getAppGroupList)
//                                                        .flatMap(List::stream)
//                                                        .map(Reference::get_id)
//                                                        .distinct()
//                                        )
//                                        .distinct()
//                                        .collect(Collectors.toList())
//                        )
//                        .build()))
//                .build());
//    }
//
//    public List getAppGroupOfGroupList(List<Reference> appGroupOfGroupReferenceList) {
//        return collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(AppGroupOfGroup.class)
//                .queryCriterias(List.of(QueryCriteria.builder()
//                        .field("_id")
//                        .operator(Operator.IN)
//                        .value(appGroupOfGroupReferenceList.stream().map(Reference::get_id).collect(Collectors.toList()))
//                        .build()))
//                .build());
//    }
//
//    public List getRoleBindingList() {
//        return collectionHandler.findAllDocumentsUsingCache(CollectionQuery.builder()
//                .clazz(AppRoleBinding.class)
//                .build());
//    }
//}