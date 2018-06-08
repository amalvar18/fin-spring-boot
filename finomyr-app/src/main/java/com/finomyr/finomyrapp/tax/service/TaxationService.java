package com.finomyr.finomyrapp.tax.service;

import java.util.List;
import java.util.Set;

import com.finomyr.finomyrapp.model.Taxation;

public interface TaxationService {

    public List<Taxation> findByActiveTrue();

    public Set<Taxation> findByAssetClassAndActiveTrue(String assetClass);

    public List<Taxation> findByNameContainsAndActive(String name);

    public Set<Taxation> findByNameContainsAndAssetClassAndActive(
            String name, String assetClass);

}
