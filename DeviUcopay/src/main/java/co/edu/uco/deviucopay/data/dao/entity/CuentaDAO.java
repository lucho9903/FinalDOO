package co.edu.uco.deviucopay.data.dao.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.entity.CuentaEntity;

public interface CuentaDAO extends CreateDAO<CuentaEntity>, DeleteDAO<UUID>, UpdateDAO<CuentaEntity>, RetriveDAO<CuentaEntity> {

}
