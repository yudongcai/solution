DO
$$
DECLARE
    nationId integer;
    addGeoLoc integer;
    aclId integer;
    orgNodeId CONSTANT integer := 1;
BEGIN

	select count(*) into addGeoLoc from common."Access_List" where "FK_LIE_Type" = 14;
	raise notice 'Existing GeoLoc ACL: %', addGeoLoc;
	IF addGeoLoc = 0 THEN
    FOR nationId IN select distinct "FK_Nation" from reference."Province_State" where "Id" in (select "FK_Province" from common."Geographical_Location") LOOP
        raise notice 'Nation: %', nationId;

        EXECUTE 'insert into common."Access_List" ("Id", "FK_LIE_Type", "Subset_Value", "FK_Access_Mode")'
                || ' values (nextval(''common."access_list_id_seq"''), 14, ' ||  nationId  || ', 2);';
    END LOOP;

    FOR aclId IN select distinct "Id" from common."Access_List" where "FK_LIE_Type" = 14 LOOP
        raise notice 'ACL: %', aclId;

        EXECUTE 'insert into common."Access_List_To_Org_Node" values (' || aclId || ', ' ||  orgNodeId || ');';
    END LOOP;

    RAISE NOTICE 'Done add READ ACL to GeoLocations to orgNode - %', orgNodeId;
	END IF;
END;
$$