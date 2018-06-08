package com.finomyr.finomyrapp.tax.repo;

import java.util.Set;

import com.finomyr.finomyrapp.model.Taxation;

public interface TaxationRepositoryCustom {

    Set<Taxation> findByAssetClassAndActiveTrue(String assetClass);

}
