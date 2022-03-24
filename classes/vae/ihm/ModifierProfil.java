/*     */ package WEB-INF.classes.vae.ihm;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.annotation.WebServlet;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import vae.bll.UtilisateurManager;
/*     */ import vae.bo.Utilisateur;
/*     */ import vae.exceptions.BusinessException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebServlet({"/modifierProfil"})
/*     */ public class ModifierProfil
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  31 */     HttpSession session = request.getSession();
/*  32 */     String pseudo = (String)session.getAttribute("login");
/*     */     
/*     */     try {
/*  35 */       Utilisateur utilisateur = UtilisateurManager.getUtilisateurManager().selectUtilisateurByPseudo(pseudo);
/*  36 */       request.setAttribute("utilisateur", utilisateur);
/*  37 */       request.setAttribute("pseudo", pseudo);
/*  38 */     } catch (BusinessException e) {
/*  39 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  42 */     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp");
/*     */     
/*  44 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  51 */     request.setCharacterEncoding("UTF-8");
/*     */     
/*  53 */     String pseudo = request.getParameter("pseudo");
/*  54 */     String nom = request.getParameter("nom");
/*  55 */     String prenom = request.getParameter("prenom");
/*  56 */     String email = request.getParameter("email");
/*  57 */     String telephone = request.getParameter("telephone");
/*  58 */     String adresse = request.getParameter("rue");
/*  59 */     String postal = request.getParameter("postal");
/*  60 */     String ville = request.getParameter("ville");
/*  61 */     String password = request.getParameter("password");
/*  62 */     String password2 = request.getParameter("password2");
/*     */ 
/*     */     
/*  65 */     if (request.getParameter("delete") != null) {
/*  66 */       System.out.println("delete true");
/*     */       try {
/*  68 */         HttpSession session = request.getSession();
/*     */         
/*  70 */         String pseudoOld = (String)session.getAttribute("login");
/*     */         
/*  72 */         UtilisateurManager.getUtilisateurManager().deleteUtilisateur(pseudoOld);
/*     */         
/*  74 */         RequestDispatcher rd = request.getRequestDispatcher("deconnexion");
/*     */         
/*  76 */         rd.forward((ServletRequest)request, (ServletResponse)response);
/*  77 */       } catch (BusinessException e) {
/*     */         
/*  79 */         e.printStackTrace();
/*     */       }
/*     */     
/*     */     }
/*  83 */     else if (password.contentEquals(password2)) {
/*  84 */       String stringPassword = "";
/*     */       
/*  86 */       if (password != "") {
/*  87 */         MessageDigest md = null;
/*     */         try {
/*  89 */           md = MessageDigest.getInstance("SHA-256");
/*  90 */         } catch (NoSuchAlgorithmException e) {
/*  91 */           e.printStackTrace();
/*     */         } 
/*     */         
/*  94 */         md.update(password.getBytes());
/*  95 */         byte[] byteData = md.digest();
/*     */         
/*  97 */         StringBuffer sb = new StringBuffer();
/*  98 */         for (int i = 0; i < byteData.length; i++) {
/*  99 */           sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
/*     */         }
/*     */         
/* 102 */         stringPassword = sb.toString();
/*     */       } 
/* 104 */       Boolean admin = Boolean.valueOf(false);
/* 105 */       int credit = 0;
/*     */       
/* 107 */       Utilisateur utilisateur = new Utilisateur(email, pseudo, stringPassword, nom, prenom, telephone, adresse, postal, ville, admin, credit);
/* 108 */       UtilisateurManager utilisateurManager = new UtilisateurManager();
/*     */       try {
/* 110 */         HttpSession session = request.getSession();
/*     */         
/* 112 */         String pseudoOld = (String)session.getAttribute("login");
/*     */         
/* 114 */         Boolean updateCheck = Boolean.valueOf(utilisateurManager.updateUtilisateur(utilisateur, pseudoOld));
/*     */         
/* 116 */         if (updateCheck.booleanValue()) {
/* 117 */           session.setAttribute("login", utilisateur.getLogin());
/*     */         }
/*     */         
/* 120 */         RequestDispatcher rd = request.getRequestDispatcher("profil");
/*     */         
/* 122 */         rd.forward((ServletRequest)request, (ServletResponse)response);
/*     */       }
/* 124 */       catch (BusinessException e) {
/* 125 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\ModifierProfil.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */