package com.finomyr.finomyrapp.tax.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finomyr.finomyrapp.model.Taxation;
import com.finomyr.finomyrapp.tax.repo.TaxationRepository;
@Service
public class TaxationServiceImpl implements TaxationService {

    @Autowired
    private TaxationRepository taxationRepository;

    @Override
    public List<Taxation> findByActiveTrue() {
        return taxationRepository.findByActiveTrue();
    }

    @Override
    public Set<Taxation> findByAssetClassAndActiveTrue(String assetClass) {
        return taxationRepository.findByAssetClassAndActiveTrue(assetClass);
    }

    @Override
    public List<Taxation> findByNameContainsAndActive(String name) {
        return taxationRepository.findByNameContainingIgnoreCaseAndActiveTrue(name);
    }

    @Override
    public Set<Taxation> findByNameContainsAndAssetClassAndActive(String name,
            String assetClass) {

        return taxationRepository.findByNameContainingIgnoreCaseAndAssetClassAndActiveTrue(name,
                assetClass);
    }

}
