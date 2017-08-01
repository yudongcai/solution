DO
$$
DECLARE
    instance character;
    addGeoLoc integer;
    aclId integer;
    orgNodeId CONSTANT integer := 1;
	lieType CONSTANT integer := ;
BEGIN

	select count(*) into addGeoLoc from common."Access_List" where "FK_LIE_Type" = 7;
	raise notice 'Existing GeoLoc ACL: %', addGeoLoc;
	IF addGeoLoc = 0 THEN
    FOR instance IN select "GUID" from common."Unit" LOOP
        raise notice 'Unit guid: %', instance;

        EXECUTE 'insert into common."Access_List" ("Id", "FK_LIE_Type", "Subset_Value", "FK_Access_Mode")'
                || ' values (nextval(''common."access_list_id_seq"''), 7, ' ||  instance  || ', 2);';
    END LOOP;

    FOR aclId IN select distinct "Id" from common."Access_List" where "FK_LIE_Type" = 7 LOOP
        raise notice 'ACL: %', aclId;

        EXECUTE 'insert into common."Access_List_To_Org_Node" values (' || aclId || ', ' ||  orgNodeId || ');';
    END LOOP;

    RAISE NOTICE 'Done add READ ACL to GeoLocations to orgNode - %', orgNodeId;
	END IF;
END;
$$