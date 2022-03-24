package WEB-INF.classes.vae.dal;

import vae.bo.Utilisateur;
import vae.exceptions.BusinessException;

public interface UtilisateurDAO {
  Utilisateur connexion(String paramString1, String paramString2) throws BusinessException;
  
  void createUtilisateur(Utilisateur paramUtilisateur) throws BusinessException;
  
  int recupererIdUtilisateur(String paramString) throws BusinessException;
  
  void deleteUtilisateur(String paramString) throws BusinessException;
  
  Boolean checkNoPseudoEmail(Utilisateur paramUtilisateur) throws BusinessException;
  
  Utilisateur selectByPseudo(String paramString) throws BusinessException;
  
  void updateUtilisateur(Utilisateur paramUtilisateur, String paramString) throws BusinessException;
  
  Boolean checkNoPseudoEmailInUpdate(Utilisateur paramUtilisateur, String paramString) throws BusinessException;
}


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\UtilisateurDAO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */