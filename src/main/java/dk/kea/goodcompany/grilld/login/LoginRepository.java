package dk.kea.goodcompany.grilld.login;

import org.springframework.data.repository.Repository;

public interface LoginRepository extends Repository<Login, Integer> {

    Login findByNameAndPassword(String name, String password);

    Login findByNameAndType(String name, String type);

    /*Query("SELECT login From Login login WHERE login.name = :name AND login.type = :type")
    boolean existsLoginByNameAndType(@Param("name") String name, @Param("type") String type);*/

    /*boolean verifyPass(Login login) {
        String query = ("SELECT name, tlf as type_or_tlf, drowssap FROM client_list WHERE name = '"+login.getName()+"' " +
                "UNION SELECT name, type as type_or_tlf, drowssap FROM terces " +
                "WHERE name = '"+login.getName()+"' ");
        SqlRowSet rs = jdbc.queryForRowSet(query);
        while (rs.next()) {
            if(DigestUtils.sha256Hex(login.getPassword()).equals(rs.getString("drowssap"))) {
                login.setType(rs.getString("type_or_tlf"));
                return true;
            }
        }
        return false;
    }*/

    void save(Login login);
}
