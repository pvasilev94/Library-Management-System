package pvasilev.cit.oossp.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pvasilev.cit.oossp.library.service.LibraryServiceImp;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.*;

/**
 * Created by Pavel on 30/08/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LibraryApp.class)
@ActiveProfiles("test")
@DirtiesContext(classMode= ClassMode.AFTER_CLASS)
public class LoanDaoImpTest {

    @Autowired
    LibraryServiceImp service;

    @Test public void findAll() {
        assertEquals(6,service.findAllLoan().size());
    }
    @Test public void findAllLoanNotReturned() {
        assertEquals(2, service.findAllLoanNotReturned().size());
    }
}
