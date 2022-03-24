/*     */ package WEB-INF.classes.vae.bo;
/*     */ 
/*     */ public class Utilisateur {
/*     */   private int id;
/*     */   private String email;
/*     */   private String login;
/*     */   private String motDePasse;
/*     */   private String nom;
/*     */   private String prenom;
/*     */   private String telephone;
/*     */   private String rue;
/*     */   private String codePostal;
/*     */   private String ville;
/*  14 */   private Boolean administrateur = Boolean.valueOf(false);
/*  15 */   private int credit = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public Utilisateur() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Utilisateur(int noUtilisateur) {
/*  24 */     this.id = noUtilisateur;
/*     */   }
/*     */   
/*     */   public Utilisateur(String login, String motDePasse) {
/*  28 */     this.login = login;
/*  29 */     this.motDePasse = motDePasse;
/*     */   }
/*     */   
/*     */   public Utilisateur(String email, String login, String motDePasse, String nom, String prenom, String telephone, String rue, String codePostal, String ville, Boolean administrateur, int credit) {
/*  33 */     this.email = email;
/*  34 */     this.login = login;
/*  35 */     this.motDePasse = motDePasse;
/*  36 */     this.nom = nom;
/*  37 */     this.prenom = prenom;
/*  38 */     this.telephone = telephone;
/*  39 */     this.rue = rue;
/*  40 */     this.codePostal = codePostal;
/*  41 */     this.ville = ville;
/*  42 */     this.administrateur = administrateur;
/*  43 */     this.credit = credit;
/*     */   }
/*     */   public Utilisateur(int id, String email, String login, String motDePasse, String nom, String prenom, String telephone, String rue, String codePostal, String ville, Boolean administrateur, int credit) {
/*  46 */     this.id = id;
/*  47 */     this.email = email;
/*  48 */     this.login = login;
/*  49 */     this.motDePasse = motDePasse;
/*  50 */     this.nom = nom;
/*  51 */     this.prenom = prenom;
/*  52 */     this.telephone = telephone;
/*  53 */     this.rue = rue;
/*  54 */     this.codePostal = codePostal;
/*  55 */     this.ville = ville;
/*  56 */     this.administrateur = administrateur;
/*  57 */     this.credit = credit;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getId() {
/*  63 */     return this.id;
/*     */   }
/*     */   public void setId(int id) {
/*  66 */     this.id = id;
/*     */   }
/*     */   public String getEmail() {
/*  69 */     return this.email;
/*     */   }
/*     */   public Boolean getAdministrateur() {
/*  72 */     return this.administrateur;
/*     */   }
/*     */   
/*     */   public void setAdministrateur(Boolean administrateur) {
/*  76 */     this.administrateur = administrateur;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/*  80 */     this.email = email;
/*     */   }
/*     */   public String getLogin() {
/*  83 */     return this.login;
/*     */   }
/*     */   public void setLogin(String login) {
/*  86 */     this.login = login;
/*     */   }
/*     */   public String getMotDePasse() {
/*  89 */     return this.motDePasse;
/*     */   }
/*     */   public void setMotDePasse(String motDePasse) {
/*  92 */     this.motDePasse = motDePasse;
/*     */   }
/*     */   public String getNom() {
/*  95 */     return this.nom;
/*     */   }
/*     */   public void setNom(String nom) {
/*  98 */     this.nom = nom;
/*     */   }
/*     */   public String getPrenom() {
/* 101 */     return this.prenom;
/*     */   }
/*     */   public void setPrenom(String prenom) {
/* 104 */     this.prenom = prenom;
/*     */   }
/*     */   public String getTelephone() {
/* 107 */     return this.telephone;
/*     */   }
/*     */   public void setTelephone(String telephone) {
/* 110 */     this.telephone = telephone;
/*     */   }
/*     */   public String getRue() {
/* 113 */     return this.rue;
/*     */   }
/*     */   public void setRue(String rue) {
/* 116 */     this.rue = rue;
/*     */   }
/*     */   public String getCodePostal() {
/* 119 */     return this.codePostal;
/*     */   }
/*     */   public void setCodePostal(String codePostal) {
/* 122 */     this.codePostal = codePostal;
/*     */   }
/*     */   public String getVille() {
/* 125 */     return this.ville;
/*     */   }
/*     */   public void setVille(String ville) {
/* 128 */     this.ville = ville;
/*     */   }
/*     */   public int getCredit() {
/* 131 */     return this.credit;
/*     */   }
/*     */   
/*     */   public void setCredit(int credit) {
/* 135 */     this.credit = credit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     return "Utilisateur [id=" + this.id + ", login=" + this.login + ", motDePasse=" + this.motDePasse + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 148 */     if (this == obj)
/* 149 */       return true; 
/* 150 */     if (obj == null)
/* 151 */       return false; 
/* 152 */     if (getClass() != obj.getClass())
/* 153 */       return false; 
/* 154 */     vae.bo.Utilisateur other = (vae.bo.Utilisateur)obj;
/* 155 */     if (this.codePostal != other.codePostal)
/* 156 */       return false; 
/* 157 */     if (this.id != other.id)
/* 158 */       return false; 
/* 159 */     if (this.login == null) {
/* 160 */       if (other.login != null)
/* 161 */         return false; 
/* 162 */     } else if (!this.login.equals(other.login)) {
/* 163 */       return false;
/* 164 */     }  if (this.motDePasse == null) {
/* 165 */       if (other.motDePasse != null)
/* 166 */         return false; 
/* 167 */     } else if (!this.motDePasse.equals(other.motDePasse)) {
/* 168 */       return false;
/* 169 */     }  if (this.nom == null) {
/* 170 */       if (other.nom != null)
/* 171 */         return false; 
/* 172 */     } else if (!this.nom.equals(other.nom)) {
/* 173 */       return false;
/* 174 */     }  if (this.prenom == null) {
/* 175 */       if (other.prenom != null)
/* 176 */         return false; 
/* 177 */     } else if (!this.prenom.equals(other.prenom)) {
/* 178 */       return false;
/* 179 */     }  if (this.rue == null) {
/* 180 */       if (other.rue != null)
/* 181 */         return false; 
/* 182 */     } else if (!this.rue.equals(other.rue)) {
/* 183 */       return false;
/* 184 */     }  if (this.telephone != other.telephone)
/* 185 */       return false; 
/* 186 */     if (this.ville == null) {
/* 187 */       if (other.ville != null)
/* 188 */         return false; 
/* 189 */     } else if (!this.ville.equals(other.ville)) {
/* 190 */       return false;
/* 191 */     }  return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\bo\Utilisateur.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */