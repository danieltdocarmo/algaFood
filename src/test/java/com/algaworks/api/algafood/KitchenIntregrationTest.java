package com.algaworks.api.algafood;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.TransactionSystemException;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.service.kitchen.CreateKitchenService;
import com.algaworks.api.algafood.domain.service.kitchen.DeleteKitchenService;

@SpringBootTest
class KitchenIntregrationTest {

    private static String KITCHEN_UUID = "6c1a5976-8e4e-4fb1-ad10-cb4384ae6c81";
    
    @Autowired
    private DeleteKitchenService deleteKitchenService;
    
    @Autowired
    private CreateKitchenService createKitchenService;

    
    @Test
    public void shouldBeAbleToCreateANewKitchen() {
        //scenery
        var kitchen = new Kitchen();
        kitchen.setName("Any Kitchen");

        //act
        final var createdKitchen = createKitchenService.execute(kitchen);
        
        //asserts
        assertNotEquals(createdKitchen, null);
        assertNotEquals(createdKitchen.getId(), null);
    }

    @Test()
    public void shouldNotBeAbleToCreateANewKitchenWithoutName() {
        //scenery
        var kitchen = new Kitchen();
        kitchen.setName(null);
                
        //asserts
        assertThrows(TransactionSystemException.class, () -> {
            
            //act
            createKitchenService.execute(kitchen);
        });
    }

    @Test
    public void shouldNotBeAbleToDeleteANonexistentKitchen() {
        
        //asserts
        assertThrows(EmptyResultDataAccessException.class, () -> {
            //act
            deleteKitchenService.execute(UUID.fromString(KITCHEN_UUID));
        });
        
    }

}