select * from finomyrs.taxation;

---
INSERT INTO finomyrs.taxation(
            "taxationId", active, "assetClass", category, created, "createdBy",
            "lastUpdated", "lastUpdatedBy", name, "taxRate", "indexationAllowed")
    VALUES (default, true, 'Equity', 'Capital Gains', current_timestamp, 'myradmin',
            current_timestamp, 'myradmin', 'Short Term Capital Gains', 0.15, default);
            
INSERT INTO finomyrs.taxation(
            "taxationId", active, "assetClass", category, created, "createdBy",
            "lastUpdated", "lastUpdatedBy", name, "taxRate", "indexationAllowed")
    VALUES (default, true, 'Equity', 'Capital Gains', current_timestamp, 'myradmin',
            current_timestamp, 'myradmin', 'Long Term Capital Gains', 0.10, default); 

INSERT INTO finomyrs.taxation(
            "taxationId", active, "assetClass", category, created, "createdBy",
            "lastUpdated", "lastUpdatedBy", name, "taxRate", "indexationAllowed")
    VALUES (default, true, 'Debt', 'Tax Exempt', current_timestamp, 'myradmin',
            current_timestamp, 'myradmin', 'Fully Tax Exempt', 0.0, default);
            
INSERT INTO finomyrs.taxation(
            "taxationId", active, "assetClass", category, created, "createdBy",
            "lastUpdated", "lastUpdatedBy", name, "taxRate", "indexationAllowed")
    VALUES (default, true, 'Debt', 'Capital Gains', current_timestamp, 'myradmin',
            current_timestamp, 'myradmin', 'Long Term Capital Gains', 0.20, true);
            
INSERT INTO finomyrs.taxation VALUES (default, false, 'Tax Exempt', 'Fully Tax Exempt', 'Equity', 0.0,
	current_timestamp, 'myradmin', current_timestamp, 'myradmin', default);          