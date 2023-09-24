package com.Java_Programming.e_commerce_backend.services;

import com.Java_Programming.e_commerce_backend.repositories.RepositoryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SaveRestServices {

    private static final Logger logger = LoggerFactory.getLogger(SaveRestServices.class);

    @Autowired
    private RepositoryHandler repositoryHandler;

    public String saveObject ( String className, Object object){
        Class<?> entityClass = null;
        try {
            entityClass = Class.forName("com.Java_Programming.e_commerce_backend." + className);
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SaveRestServices.class);
            RepositoryHandler<?, String> repository = applicationContext.getBean(RepositoryHandler.class);
            if (entityClass != null) {
                repositoryHandler.save(object);
            }
            logger.info("saved into DB {} ");
        } catch (ClassNotFoundException e) {
            logger.info("Entity class not found for name: "+className);
            throw new IllegalArgumentException("Entity class not found for name: " + className);
        }

        return "Object saved successfully.";
    }
}
