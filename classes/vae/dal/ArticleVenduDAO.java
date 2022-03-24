package WEB-INF.classes.vae.dal;

import java.util.List;
import vae.bo.ArticleVendu;
import vae.bo.Categorie;
import vae.exceptions.BusinessException;

public interface ArticleVenduDAO {
  int insert(ArticleVendu paramArticleVendu) throws BusinessException;
  
  ArticleVendu selectParNoArticle(int paramInt) throws BusinessException;
  
  void update(ArticleVendu paramArticleVendu) throws Exception;
  
  ArticleVendu read(int paramInt) throws Exception;
  
  List<Categorie> obtenirCategories() throws Exception;
  
  List<ArticleVendu> selectParNomEtCategorie(String paramString, Categorie paramCategorie) throws Exception;
}


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\ArticleVenduDAO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */