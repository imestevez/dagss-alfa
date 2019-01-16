/*
 Proyecto Java EE, DAGSS-2014
 */

package es.uvigo.esei.dagss.dominio.daos;

import es.uvigo.esei.dagss.dominio.entidades.Receta;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class RecetaDAO extends GenericoDAO<Receta>{
 
    public List<Receta> buscarRecetasEnVigor(String numeroTarjetaSanitaria){
        Date fecha = Calendar.getInstance().getTime();
        
        TypedQuery<Receta> q = em.createQuery("SELECT receta FROM Receta AS receta"
                                              + "  WHERE receta.prescripcion.paciente.numeroTarjetaSanitaria = :numeroTarjetaSanitaria"
                                              + "  AND receta.finValidez > :fecha"
                                              , Receta.class);
        q.setParameter("numeroTarjetaSanitaria", numeroTarjetaSanitaria);
        q.setParameter("fecha", fecha);
        return q.getResultList();
    }
    
}
