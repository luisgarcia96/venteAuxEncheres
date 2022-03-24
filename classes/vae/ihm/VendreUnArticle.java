/*     */ package WEB-INF.classes.vae.ihm;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.time.LocalDate;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.time.format.DateTimeParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.annotation.MultipartConfig;
/*     */ import javax.servlet.annotation.WebServlet;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import javax.servlet.http.Part;
/*     */ import vae.bll.ArticleVenduManager;
/*     */ import vae.bll.UtilisateurManager;
/*     */ import vae.bo.ArticleVendu;
/*     */ import vae.bo.Categorie;
/*     */ import vae.bo.Utilisateur;
/*     */ import vae.exceptions.BusinessException;
/*     */ import vae.ihm.PropertiesReader;
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
/*     */ @MultipartConfig(fileSizeThreshold = 1048576, maxFileSize = 10485760L, maxRequestSize = 104857600L)
/*     */ @WebServlet({"/vendreUnArticle"})
/*     */ public class VendreUnArticle
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String IMAGES_FOLDER = "/fichiers/images";
/*     */   public String uploadPath;
/*     */   
/*     */   public void init() throws ServletException {
/*  59 */     PropertiesReader lecteurChemin = PropertiesReader.getInstance();
/*     */     
/*  61 */     this.uploadPath = lecteurChemin.getValue("fichierPath");
/*     */     
/*  63 */     File uploadDir = new File(String.valueOf(this.uploadPath) + "/fichiers/images");
/*     */     
/*  65 */     if (!uploadDir.exists()) {
/*  66 */       uploadDir.mkdirs();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  74 */     HttpSession session = request.getSession();
/*     */     
/*  76 */     if (session.getAttribute("login") == null) {
/*  77 */       RequestDispatcher rd = request.getRequestDispatcher("/createUser");
/*  78 */       rd.forward((ServletRequest)request, (ServletResponse)response);
/*     */     } else {
/*     */       
/*  81 */       ArticleVenduManager articleVenduManager = new ArticleVenduManager();
/*     */       
/*     */       try {
/*  84 */         List<Categorie> listeCategories = articleVenduManager.afficherCategories();
/*  85 */         request.setAttribute("listeCategories", listeCategories);
/*  86 */       } catch (Exception e) {
/*  87 */         e.printStackTrace();
/*     */       } 
/*     */       
/*  90 */       String pseudo = (String)session.getAttribute("login");
/*     */       try {
/*  92 */         Utilisateur utilisateur = UtilisateurManager.getUtilisateurManager().selectUtilisateurByPseudo(pseudo);
/*  93 */         request.setAttribute("rue", utilisateur.getRue());
/*  94 */         request.setAttribute("codePostal", utilisateur.getCodePostal());
/*  95 */         request.setAttribute("ville", utilisateur.getVille());
/*  96 */       } catch (BusinessException e) {
/*  97 */         e.printStackTrace();
/*     */       } 
/*     */       
/* 100 */       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/vendre_un_article.jsp");
/* 101 */       rd.forward((ServletRequest)request, (ServletResponse)response);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 112 */     String nomArticle = null;
/* 113 */     String description = null;
/* 114 */     LocalDate dateDebutEncheres = null;
/* 115 */     LocalDate dateFinEncheres = null;
/*     */     
/* 117 */     int noUtilisateur = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     request.setCharacterEncoding("UTF-8");
/*     */ 
/*     */     
/* 125 */     List<Integer> listeCodesErreur = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     HttpSession session = request.getSession();
/* 131 */     String login = (String)session.getAttribute("login");
/*     */     
/* 133 */     if (login != null) {
/*     */       
/* 135 */       UtilisateurManager utilisateurManager = new UtilisateurManager();
/*     */       try {
/* 137 */         noUtilisateur = utilisateurManager.recupererIdUtilisateur(login);
/* 138 */       } catch (BusinessException e) {
/*     */         
/* 140 */         e.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       
/* 144 */       RequestDispatcher rd = request.getRequestDispatcher("/accueil");
/* 145 */       rd.forward((ServletRequest)request, (ServletResponse)response);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 150 */     nomArticle = request.getParameter("nomArticle");
/* 151 */     if (nomArticle.isEmpty() || nomArticle.length() > 30) {
/* 152 */       listeCodesErreur.add(Integer.valueOf(30000));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 157 */     description = request.getParameter("description");
/* 158 */     if (description.isEmpty() || description.length() > 300 || description.length() < 10) {
/* 159 */       listeCodesErreur.add(Integer.valueOf(30001));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 166 */       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 167 */       dateDebutEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres"), dtf);
/* 168 */     } catch (DateTimeParseException e) {
/* 169 */       e.printStackTrace();
/* 170 */       listeCodesErreur.add(Integer.valueOf(30003));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 176 */       DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 177 */       dateFinEncheres = LocalDate.parse(request.getParameter("dateFinEncheres"), dtf1);
/* 178 */     } catch (DateTimeParseException e) {
/* 179 */       e.printStackTrace();
/* 180 */       listeCodesErreur.add(Integer.valueOf(30004));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 185 */     int prixVente = Integer.parseInt(request.getParameter("prixVente"));
/* 186 */     if (prixVente <= 0) {
/* 187 */       listeCodesErreur.add(Integer.valueOf(30005));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     int noCategorie = Integer.parseInt(request.getParameter("categorie"));
/* 194 */     if (noCategorie == 0) {
/* 195 */       listeCodesErreur.add(Integer.valueOf(30002));
/*     */     }
/*     */ 
/*     */     
/* 199 */     if (listeCodesErreur.size() > 0) {
/*     */ 
/*     */ 
/*     */       
/* 203 */       request.setAttribute("listeCodesErreur", listeCodesErreur);
/*     */ 
/*     */       
/* 206 */       doGet(request, response);
/*     */     }
/*     */     else {
/*     */       
/* 210 */       ArticleVenduManager articleVenduManager = new ArticleVenduManager();
/*     */ 
/*     */       
/*     */       try {
/* 214 */         int noArticle = articleVenduManager.ajouterArticle(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixVente, noUtilisateur, noCategorie).getNoArticle();
/*     */         
/* 216 */         ArticleVendu articleVendu = new ArticleVendu(noArticle);
/*     */ 
/*     */         
/*     */         try {
/* 220 */           Part part = request.getPart("imageArticle");
/* 221 */           String fileName = getFileName(part);
/* 222 */           String fileRelativePath = "/fichiers/images" + File.separator + login + "_" + fileName;
/* 223 */           String fullPath = String.valueOf(this.uploadPath) + fileRelativePath;
/*     */           
/* 225 */           part.write(fullPath);
/*     */           
/* 227 */           articleVenduManager.saveImage(articleVendu, fileRelativePath);
/*     */         }
/* 229 */         catch (Exception e) {
/* 230 */           e.printStackTrace();
/*     */         } 
/*     */         
/* 233 */         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticleReussi.jsp");
/* 234 */         rd.forward((ServletRequest)request, (ServletResponse)response);
/* 235 */       } catch (BusinessException e) {
/*     */         
/* 237 */         e.printStackTrace();
/* 238 */         request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
/*     */ 
/*     */         
/* 241 */         doGet(request, response);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getFileName(Part part) {
/*     */     byte b;
/*     */     int i;
/*     */     String[] arrayOfString;
/* 253 */     for (i = (arrayOfString = part.getHeader("content-disposition").split(";")).length, b = 0; b < i; ) { String content = arrayOfString[b];
/*     */       
/* 255 */       if (content.trim().startsWith("filename"))
/*     */       {
/* 257 */         return content.substring(content.indexOf("=") + 2, content.length() - 1); } 
/*     */       b++; }
/*     */     
/* 260 */     return "Default.file";
/*     */   }
/*     */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\VendreUnArticle.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */