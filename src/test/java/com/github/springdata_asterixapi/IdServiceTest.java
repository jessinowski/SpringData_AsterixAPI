package com.github.springdata_asterixapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.UUID;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({UUID.class})
////class IdServiceTest {
////    IdService idService =new IdService();
////    @Test
////    void randomId() {
////        String mockedUUID = UUID.randomUUID().toString();
////        PowerMockito.mockStatic(UUID.class);
////        when(UUID.randomUUID()).thenReturn(UUID.fromString(mockedUUID));
////        String generateID = idService.randomId();
////        assertEquals(mockedUUID,generateID);
////        PowerMockito.verifyStatic(UUID.class,times(1));
////        UUID.randomUUID();
////    }
//}