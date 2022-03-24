/*     */ package WEB-INF.classes.vae.bll;
/*     */ 
/*     */ import java.time.LocalDate;
/*     */ import java.util.List;
/*     */ import vae.bo.ArticleVendu;
/*     */ import vae.bo.Categorie;
/*     */ import vae.bo.Utilisateur;
/*     */ import vae.dal.ArticleVenduDAO;
/*     */ import vae.dal.DAOFactory;
/*     */ import vae.exceptions.BusinessException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArticleVenduManager
/*     */ {
/*     */   private static ArticleVenduDAO articleVenduDAO;
/*     */   
/*     */   public ArticleVenduManager() {
/*  21 */     articleVenduDAO = DAOFactory.getArticleVendu();
/*     */   }
/*     */ 
/*     */   
/*     */   public ArticleVendu ajouterArticle(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int prixVente, int noUtilisateur, int noCategorie) throws BusinessException {
/*  26 */     BusinessException businessException = new BusinessException();
/*  27 */     validerLongueurNomArticle(nomArticle, businessException);
/*  28 */     validerLongueurDescriptionArticle(description, businessException);
/*  29 */     validerDates(dateDebutEncheres, dateFinEncheres, businessException);
/*  30 */     validerPrixArticle(prixVente, businessException);
/*     */     
/*  32 */     ArticleVendu articleVendu = new ArticleVendu();
/*  33 */     Utilisateur utilisateur = new Utilisateur(noUtilisateur);
/*  34 */     Categorie categorie = new Categorie(noCategorie);
/*     */     
/*  36 */     if (!businessException.hasError()) {
/*     */       
/*  38 */       articleVendu.setNomArticle(nomArticle);
/*  39 */       articleVendu.setDescription(description);
/*  40 */       articleVendu.setDateDebutEncheres(dateDebutEncheres);
/*  41 */       articleVendu.setDateFinEncheres(dateFinEncheres);
/*  42 */       articleVendu.setPrixVente(prixVente);
/*  43 */       articleVendu.setUtilisateurArticle(utilisateur);
/*  44 */       articleVendu.setCategorie(categorie);
/*     */ 
/*     */       
/*  47 */       articleVendu.setNoArticle(articleVenduDAO.insert(articleVendu));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  52 */       throw businessException;
/*     */     } 
/*  54 */     return articleVendu;
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveImage(ArticleVendu articleVendu, String fileRelativePath) throws Exception {
/*  59 */     if (fileRelativePath != null && !fileRelativePath.isEmpty()) {
/*     */       
/*  61 */       articleVendu.setImageArticle(fileRelativePath);
/*  62 */       articleVenduDAO.update(articleVendu);
/*     */     } else {
/*  64 */       throw new Exception("Error File");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ArticleVendu find(int noArticle) throws Exception {
/*  70 */     if (noArticle != 0) {
/*  71 */       ArticleVendu articleVendu = articleVenduDAO.read(noArticle);
/*  72 */       return articleVendu;
/*     */     } 
/*  74 */     throw new Exception("Error find by id = " + noArticle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Categorie> afficherCategories() throws Exception {
/*  80 */     List<Categorie> listeCategories = articleVenduDAO.obtenirCategories();
/*     */     
/*  82 */     return listeCategories;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArticleVendu> selectParNomEtCategorie(String nom, Categorie categorie) throws Exception {
/*  88 */     List<ArticleVendu> listeArticlesVendus = articleVenduDAO.selectParNomEtCategorie(nom, categorie);
/*     */     
/*  90 */     return listeArticlesVendus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validerLongueurNomArticle(String nom, BusinessException businessException) {
/*  97 */     if (nom == null || nom.length() > 30) {
/*  98 */       businessException.ajouterErreur(20000);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void validerLongueurDescriptionArticle(String description, BusinessException businessException) {
/* 104 */     if (description == null || description.length() > 300) {
/* 105 */       businessException.ajouterErreur(20001);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void validerPrixArticle(int prixVente, BusinessException businessException) {
/* 111 */     if (prixVente <= 0) {
/* 112 */       businessException.ajouterErreur(20002);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void validerDates(LocalDate dateDebutEncherer, LocalDate dateFinEncheres, BusinessException businessException) {
/* 118 */     if (dateDebutEncherer == null || dateFinEncheres == null || dateDebutEncherer.isBefore(LocalDate.now()) || dateFinEncheres.isBefore(LocalDate.now()))
/*     */     {
/* 120 */       businessException.ajouterErreur(20003);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\bll\ArticleVenduManager.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */