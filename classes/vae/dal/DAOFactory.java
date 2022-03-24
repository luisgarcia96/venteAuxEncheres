/*    */ package WEB-INF.classes.vae.dal;
/*    */ import vae.dal.ArticleVenduDAO;
/*    */ 
/*    */ public abstract class DAOFactory {
/*    */   public static UtilisateurDAO getUtilisateurDAO() {
/*  6 */     return (UtilisateurDAO)new UtilisateurDAOJdbcImpl();
/*    */   }
/*    */   
/*    */   public static ArticleVenduDAO getArticleVendu() {
/* 10 */     return (ArticleVenduDAO)new ArticleVenduDAOJdbcImpl();
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\DAOFactory.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */