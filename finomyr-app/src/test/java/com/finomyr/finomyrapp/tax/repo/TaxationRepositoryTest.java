package com.finomyr.finomyrapp.tax.repo;

import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.finomyr.finomyrapp.model.Taxation;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@DataJpaTest*/
public class TaxationRepositoryTest {

    @Autowired
    TaxationRepository taxationRepository;

    @Test
    public void testFindByActiveTrue() throws Exception {
        List<Taxation> taxList = taxationRepository.findByActiveTrue();
        for (Taxation taxItem : taxList) {
            System.out.println(taxItem.toString());
        }

        Assert.notEmpty(taxList, "No active taxation items");
    }

    @Test
    public void testFindByAssetClassAndActiveTrue() throws Exception {
        Set<Taxation> taxSet = taxationRepository.findByAssetClassAndActiveTrue("Equity");
        for (Taxation taxItem : taxSet) {
            System.out.println(taxItem.toString());
        }
        assertThat(taxSet.size(), CoreMatchers.is(2));
        /*Assert.notEmpty(taxSet, "No active taxation items");*/
    }

    @Test
    public void testFindByNameContains() throws Exception {
        Set<Taxation> taxSet = taxationRepository
                .findByNameContainingIgnoreCaseAndAssetClassAndActiveTrue("nG ter", "Equity");
        for (Taxation taxItem : taxSet) {
            System.out.println(taxItem.toString());
        }
        assertThat(taxSet.size(), CoreMatchers.is(1));
        /*Assert.notEmpty(taxSet, "No active taxation items");*/
    }
}
