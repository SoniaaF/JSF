package fr.fs.jsf.dao;

public class DaoFactory {

    public static CouleurDAO getCouleurDAO() {
        return new CouleurDAO(SdbmAPI.getInstance());
    }

    public static RegionDAO getRegionDAO() {
        return new RegionDAO(GeoAPI.getInstance());
    }

    public static DepartementDAO getDepartementDao() {
        return new DepartementDAO(GeoAPI.getInstance());
    }
}
