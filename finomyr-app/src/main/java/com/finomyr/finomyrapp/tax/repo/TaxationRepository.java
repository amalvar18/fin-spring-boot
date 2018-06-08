/**
 * 
 */
package com.finomyr.finomyrapp.tax.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.finomyr.finomyrapp.model.Taxation;

/**
 * @author amalvar
 *
 */
@Repository
public interface TaxationRepository extends PagingAndSortingRepository<Taxation, Integer> {

    public List<Taxation> findByActiveTrue();

    public Set<Taxation> findByAssetClassAndActiveTrue(String assetClass);

    public List<Taxation> findByNameContainingIgnoreCaseAndActiveTrue(String name);

    public Set<Taxation> findByNameContainingIgnoreCaseAndAssetClassAndActiveTrue(
            String name, String assetClass);

}
