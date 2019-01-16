/*
 Proyecto Java EE, DAGSS-2014
 */
package es.uvigo.esei.dagss.dominio.daos;

import es.uvigo.esei.dagss.dominio.entidades.Medicamento;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class MedicamentoDAO extends GenericoDAO<Medicamento> {

    //Obtener medicamentos por datos
    public List<Medicamento> buscarMedicamentos(String query) {
        TypedQuery<Medicamento> q = em.createQuery("SELECT m FROM Medicamento AS m "
                + "  WHERE (m.nombre LIKE :query) OR "
                + "        (m.fabricante LIKE :query) OR (m.principioActivo LIKE :query) OR (m.familia LIKE :query) ", Medicamento.class);
        q.setParameter("query", "%" + query + "%");
        return q.getResultList();
    }

    public List<Medicamento> buscarPorMedicamento(String nombre, String familia, String fabricante) {
        TypedQuery query = em.createQuery(
                "SELECT m FROM Medicamento AS m "
                + "WHERE (m.nombre LIKE :nombre) "
                + "AND (m.fabricante LIKE :fabricante)"
                + "AND (m.familia LIKE :familia) "
                + "ORDER BY m.nombre ", Medicamento.class);

        query.setParameter("nombre", "%" + nombre + "%");
        query.setParameter("fabricante", "%" + fabricante + "%");
        query.setParameter("familia", "%" + familia + "%");

        return query.getResultList();
    }
}
