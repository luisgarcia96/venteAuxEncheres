/*     */ package WEB-INF.classes.vae.dal;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import vae.bo.ArticleVendu;
/*     */ import vae.bo.Categorie;
/*     */ import vae.dal.ArticleVenduDAO;
/*     */ import vae.dal.ConnectionProvider;
/*     */ import vae.exceptions.BusinessException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArticleVenduDAOJdbcImpl
/*     */   implements ArticleVenduDAO
/*     */ {
/*     */   private static final String INSERT_ARTICLE = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";
/*     */   private static final String RECUPERER_NO_UTILISATEUR = "SELECT no_utilisateur FROM utilisateurs WHERE (pseudo = ?) or (email = ?)";
/*     */   private static final String UPDATE_IMAGE_BY_ID = "update articles_vendus set image_article = ? where no_article=?";
/*     */   private static final String SELECT_BY_ID = "select no_article, nom_article, image_article from articles_vendus where no_article=?";
/*     */   private static final String SELECT_ARTICLE_PAR_NUM = "SELECT nom_article FROM articles_vendus WHERE no_article = ?";
/*     */   private static final String SELECT_ARTICLES_BY_NOM_ET_CATEGORIE = "SELECT b.pseudo, a.no_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_vente, a.no_categorie, a.image_article  FROM articles_vendus a INNER JOIN utilisateurs b ON a.no_utilisateur = b.no_utilisateur WHERE (no_categorie=?) AND (nom_article LIKE ?)";
/*     */   private static final String SELECT_CATEGORIES = "SELECT no_categorie, libelle FROM categories";
/*     */   
/*     */   public int insert(ArticleVendu articleVendu) throws BusinessException {
/*     */     
/*  53 */     try { Exception exception1 = null, exception2 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {  }
/*     */       finally
/*  85 */       { exception2 = null; if (exception1 == null) { exception1 = exception2; } else if (exception1 != exception2) { exception1.addSuppressed(exception2); }  }  } catch (Exception e)
/*  86 */     { e.printStackTrace();
/*     */       
/*  88 */       BusinessException businessException = new BusinessException();
/*  89 */       businessException.ajouterErreur(10100);
/*  90 */       throw businessException; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArticleVendu selectParNoArticle(int noArticle) throws BusinessException {
/* 100 */     ArticleVendu articleVendu = new ArticleVendu();
/*     */     try {
/* 102 */       Connection cnx = ConnectionProvider.getConnection();
/* 103 */       PreparedStatement pstmt = cnx.prepareStatement("SELECT nom_article FROM articles_vendus WHERE no_article = ?");
/* 104 */       pstmt.setInt(1, noArticle);
/*     */       
/* 106 */       ResultSet rs = pstmt.executeQuery();
/*     */       
/* 108 */       articleVendu = articleBuilder(rs);
/*     */     
/*     */     }
/* 111 */     catch (SQLException e) {
/* 112 */       e.printStackTrace();
/*     */       
/* 114 */       BusinessException businessException = new BusinessException();
/* 115 */       businessException.ajouterErreur(10101);
/* 116 */       throw businessException;
/*     */     } 
/* 118 */     return articleVendu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ArticleVendu articleBuilder(ResultSet rs) throws SQLException {
/* 126 */     ArticleVendu articleVendu = new ArticleVendu();
/* 127 */     articleVendu.setNoArticle(rs.getInt("no_article"));
/* 128 */     articleVendu.setNomArticle(rs.getString("nom_article"));
/* 129 */     articleVendu.setDescription(rs.getString("description"));
/* 130 */     articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
/* 131 */     articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
/* 132 */     articleVendu.setMisAPrix(rs.getInt("prix_initial"));
/* 133 */     articleVendu.setPrixVente(rs.getInt("prix_vente"));
/*     */     
/* 135 */     return articleVendu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(ArticleVendu articleVendu) throws Exception {
/*     */     try {
/* 143 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 151 */     catch (Exception e) {
/* 152 */       e.printStackTrace();
/*     */       
/* 154 */       BusinessException businessException = new BusinessException();
/* 155 */       businessException.ajouterErreur(10102);
/* 156 */       throw businessException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArticleVendu read(int noArticle) throws Exception {
/*     */     
/* 166 */     try { Exception exception1 = null, exception2 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {  }
/*     */       finally
/* 178 */       { exception2 = null; if (exception1 == null) { exception1 = exception2; } else if (exception1 != exception2) { exception1.addSuppressed(exception2); }  }  } catch (Exception e)
/* 179 */     { e.printStackTrace();
/* 180 */       throw e; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ArticleVendu mapping(ResultSet rs) throws SQLException {
/* 187 */     ArticleVendu articleVendu = new ArticleVendu();
/* 188 */     articleVendu.setNoArticle(rs.getInt("no_article"));
/* 189 */     articleVendu.setNomArticle(rs.getString("nom_article"));
/* 190 */     articleVendu.setImageArticle(rs.getString("image"));
/* 191 */     return articleVendu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Categorie> obtenirCategories() throws Exception {
/* 201 */     List<Categorie> listeCategories = new ArrayList<>();
/*     */     try {
/* 203 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 215 */     catch (SQLException e) {
/* 216 */       e.printStackTrace();
/*     */       
/* 218 */       BusinessException businessException = new BusinessException();
/* 219 */       businessException.ajouterErreur(10103);
/* 220 */       throw businessException;
/*     */     } 
/* 222 */     return listeCategories;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArticleVendu> selectParNomEtCategorie(String nom, Categorie categorie) throws Exception {
/* 230 */     List<ArticleVendu> listeArticleVendus = new ArrayList<>();
/*     */     try {
/* 232 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 266 */     catch (SQLException e) {
/* 267 */       e.printStackTrace();
/*     */       
/* 269 */       BusinessException businessException = new BusinessException();
/* 270 */       businessException.ajouterErreur(101034);
/* 271 */       throw businessException;
/*     */     } 
/*     */     
/* 274 */     return listeArticleVendus;
/*     */   }
/*     */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\ArticleVenduDAOJdbcImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */