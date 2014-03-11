package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_BankDao {

    public Map<String, Object> GetBANK();
    public Map<String, Object>  InsertBANK(clsBANK BANK);
    public Map<String, Object>  UpdateBANK(clsBANK BANK);
    public Map<String, Object>  DeleteBANK(clsBANK BANK);

}
