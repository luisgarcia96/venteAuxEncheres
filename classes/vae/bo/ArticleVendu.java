/*     */ package WEB-INF.classes.vae.bo;
/*     */ 
/*     */ import java.time.LocalDate;
/*     */ import vae.bo.Categorie;
/*     */ import vae.bo.Utilisateur;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArticleVendu
/*     */ {
/*     */   private int noArticle;
/*     */   private String nomArticle;
/*     */   private String description;
/*     */   private LocalDate dateDebutEncheres;
/*     */   private LocalDate dateFinEncheres;
/*     */   private int misAPrix;
/*     */   private int prixVente;
/*     */   private String etatVente;
/*     */   private Categorie categorie;
/*     */   private Utilisateur utilisateurArticle;
/*     */   private String imageArticle;
/*     */   
/*     */   public ArticleVendu() {}
/*     */   
/*     */   public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int prixVente, Categorie categorie) {
/*  26 */     this.nomArticle = nomArticle;
/*  27 */     this.description = description;
/*  28 */     this.dateDebutEncheres = dateDebutEncheres;
/*  29 */     this.dateFinEncheres = dateFinEncheres;
/*  30 */     this.prixVente = prixVente;
/*  31 */     this.categorie = categorie;
/*     */   }
/*     */   
/*     */   public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int prixVente, Categorie categorie) {
/*  35 */     this.noArticle = noArticle;
/*  36 */     this.nomArticle = nomArticle;
/*  37 */     this.description = description;
/*  38 */     this.dateDebutEncheres = dateDebutEncheres;
/*  39 */     this.dateFinEncheres = dateFinEncheres;
/*  40 */     this.prixVente = prixVente;
/*  41 */     this.categorie = categorie;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArticleVendu(int noArticle) {
/*  48 */     this.noArticle = noArticle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNoArticle() {
/*  55 */     return this.noArticle;
/*     */   }
/*     */   public void setNoArticle(int noArticle) {
/*  58 */     this.noArticle = noArticle;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNomArticle() {
/*  63 */     return this.nomArticle;
/*     */   }
/*     */   public void setNomArticle(String nomArticle) {
/*  66 */     this.nomArticle = nomArticle;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  71 */     return this.description;
/*     */   }
/*     */   public void setDescription(String description) {
/*  74 */     this.description = description;
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalDate getDateDebutEncheres() {
/*  79 */     return this.dateDebutEncheres;
/*     */   }
/*     */   public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
/*  82 */     this.dateDebutEncheres = dateDebutEncheres;
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalDate getDateFinEncheres() {
/*  87 */     return this.dateFinEncheres;
/*     */   }
/*     */   public void setDateFinEncheres(LocalDate dateFinEncheres) {
/*  90 */     this.dateFinEncheres = dateFinEncheres;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMisAPrix() {
/*  95 */     return this.misAPrix;
/*     */   }
/*     */   public void setMisAPrix(int misAPrix) {
/*  98 */     this.misAPrix = misAPrix;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPrixVente() {
/* 103 */     return this.prixVente;
/*     */   }
/*     */   public void setPrixVente(int prixVente) {
/* 106 */     this.prixVente = prixVente;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getEtatVente() {
/* 111 */     return this.etatVente;
/*     */   }
/*     */   public void setEtatVente(String etatVente) {
/* 114 */     this.etatVente = etatVente;
/*     */   }
/*     */ 
/*     */   
/*     */   public Categorie getCategorie() {
/* 119 */     return this.categorie;
/*     */   }
/*     */   public void setCategorie(Categorie categorie) {
/* 122 */     this.categorie = categorie;
/*     */   }
/*     */ 
/*     */   
/*     */   public Utilisateur getUtilisateurArticle() {
/* 127 */     return this.utilisateurArticle;
/*     */   }
/*     */   public void setUtilisateurArticle(Utilisateur utilisateurArticle) {
/* 130 */     this.utilisateurArticle = utilisateurArticle;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getImageArticle() {
/* 135 */     return this.imageArticle;
/*     */   }
/*     */   public void setImageArticle(String imageArticle) {
/* 138 */     this.imageArticle = imageArticle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     return "ArticleVendu [noArticle=" + this.noArticle + ", nomArticle=" + this.nomArticle + ", description=" + this.description + 
/* 147 */       ", dateDebutEncheres=" + this.dateDebutEncheres + ", dateFinEncheres=" + this.dateFinEncheres + ", misAPrix=" + 
/* 148 */       this.misAPrix + ", prixVente=" + this.prixVente + ", etatVente=" + this.etatVente + ", categorie=" + this.categorie.getNoCategorie() + 
/* 149 */       ", utilisateurArticle=" + this.utilisateurArticle.getPrenom() + " " + this.utilisateurArticle.getNom() + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIdUtilisateurArticle() {
/* 156 */     int idUtilisateurArticle = getUtilisateurArticle().getId();
/*     */     
/* 158 */     return idUtilisateurArticle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNoCategorieArticle() {
/* 164 */     int noCategorieArticle = getCategorie().getNoCategorie();
/*     */     
/* 166 */     return noCategorieArticle;
/*     */   }
/*     */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\bo\ArticleVendu.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */