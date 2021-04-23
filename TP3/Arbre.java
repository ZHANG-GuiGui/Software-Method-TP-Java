class Arbre <T>{
  protected T valeur;
  protected int value;
  protected Arbre<T> filsGauche, filsDroit;

  public T valeur() {
    return valeur;
  }
  public boolean existeFilsGauche() {
    return filsGauche != null;
  }
  public boolean existeFilsDroit() {
    return filsDroit != null;
  }
  public Arbre<T> filsGauche() {
    return filsGauche;
  }
  public Arbre<T> filsDroit() {
    return filsDroit;
  }
  public void affecterValeur(T c) {
    valeur = c;
  }
  public void affecterFilsGauche(Arbre<T> g) {
    filsGauche = g;
  }
  public void affecterFilsDroit(Arbre<T> d) {
    filsDroit = d;
  }
  public boolean feuille() {
    return (filsDroit==null && filsGauche==null);
  }
  public int hauteur() {
    int g = existeFilsGauche() ? filsGauche.hauteur() : 0;
    int d = existeFilsDroit() ? filsDroit.hauteur() : 0;
    return 1 + Math.max(g, d);
  }
  // Constructeurs
  public Arbre(T val) {
    valeur = val;
    filsGauche = filsDroit = null;
  }
  public Arbre(T val, Arbre<T> g, Arbre<T> d) {
    valeur = val;
    filsGauche = g; filsDroit = d;
  }
  // Affichage
  public void afficherPrefixe() {
    System.out.print(valeur+"\t");
    if (existeFilsGauche()) filsGauche.afficherPrefixe();
    if (existeFilsDroit())  filsDroit.afficherPrefixe();
  }
  public void afficherInfixe() {
    if (existeFilsGauche()) filsGauche.afficherInfixe();
    System.out.print(valeur+"\t");
    if (existeFilsDroit())filsDroit.afficherInfixe();
  }
  public void afficherPostfixe() {
    if (existeFilsGauche()) filsGauche.afficherPostfixe();
    if (existeFilsDroit())filsDroit.afficherPostfixe();
    System.out.print(valeur+"\t");
  }
  //This function gives the calculated value with a given x.
  public Double calculNum(Double valeur){
    if (this.hauteur()>1){
      if (this.valeur().equals("+")){
        return this.filsGauche().calculNum(valeur)+this.filsDroit().calculNum(valeur);
      }else if (this.valeur().equals("-")){
        return this.filsGauche().calculNum(valeur)-this.filsDroit().calculNum(valeur);
      }else if (this.valeur().equals("*")){
        return this.filsGauche().calculNum(valeur)*this.filsDroit().calculNum(valeur);
      }else if (this.valeur().equals("/")){
        return this.filsGauche().calculNum(valeur)/this.filsDroit().calculNum(valeur);
      }else if (this.valeur().equals("^")){
        return Math.pow(this.filsGauche().calculNum(valeur),this.filsDroit().calculNum(valeur));
      }
    }else{
      if (this.valeur().equals("x")){
        return valeur;
      }else{
        return Double.valueOf((String)this.valeur());
      }
    }
    return null;
  }
  //This function can determine if the tree a smallest tree. (with at least one node a leaf node).
  public boolean smallArbre(Arbre<T> arb){
    boolean res = true;
    if (arb.hauteur()==1){
      return res;
    }else{
      return (arb.filsGauche().feuille() || arb.filsDroit().feuille());
    }
  }
  //This function is to change this tree. Because we cannot directly utilize this = arb.
  public void changeThis(Arbre<T> arb){
    this.valeur = arb.valeur();
    this.filsGauche = arb.filsGauche();
    this.filsDroit = arb.filsDroit();
  }
  //This function is to simplify the tree with
  //0+SA,SA+0
  //SA-0
  //1*SA,SA*1,0*SA,SA*0
  //0/SA,SA/1
  //SA^0,SA^1,1^SA
  public void simplification(){
    if (this.hauteur()!=1){
      if (!this.smallArbre(this)){
        this.filsGauche().simplification();
        this.filsDroit().simplification();
      }else{
        if (this.valeur().equals("+")){
          if (this.filsGauche().valeur().equals("0")){
            this.changeThis(this.filsDroit());
            this.simplification();
          }else if (this.filsDroit().valeur().equals("0")){
            this.changeThis(this.filsGauche());
            this.simplification();
          }
        }else if (this.valeur().equals("-")){
          if (this.filsDroit().valeur().equals("0")){
            this.changeThis(this.filsGauche());
            this.simplification();
          }
        }else if (this.valeur().equals("*")){
          if (this.filsGauche().valeur().equals("1")){
            this.changeThis(this.filsDroit());
            this.simplification();
          }else if (this.filsDroit().valeur().equals("1")){
            this.changeThis(this.filsGauche());
            this.simplification();
          }else if (this.filsGauche().valeur().equals("0")||this.filsDroit().valeur().equals("0")){
            this.changeThis(new Arbre("0"));
            this.simplification();
          }
        }else if (this.valeur().equals("/")){
          if (this.filsGauche().valeur().equals("0")){
            this.changeThis(new Arbre("0"));
            this.simplification();
          }else if (this.filsDroit().valeur().equals("1")){
            this.changeThis(this.filsGauche());
            this.simplification();
          }
        }else if (this.valeur().equals("^")){
          if (this.filsDroit().valeur().equals("1")){
            this.changeThis(this.filsGauche());
            this.simplification();
          }else if (this.filsDroit().valeur().equals("0")||this.filsGauche().valeur().equals("1")){
            this.changeThis(new Arbre("1"));
            this.simplification();
          }
        }
      }
    }
  }
  //cette fonction ne peut traiter que des Polynomes sous la forme
  //SUM_i(a_i*(x^i))
  //Par exemple : (5*(x^4))+((3*(x^2))+(x+1))
  public void derivePoly(){
    if (this.hauteur()!=1){
      if (!this.smallArbre(this)){
        this.filsGauche().derivePoly();
        this.filsDroit().derivePoly();
      }else{
        if (this.valeur().equals("+")||this.valeur().equals("-")){
          String valeurGauche = this.filsGauche().valeur().toString();
          String valeurDroit = this.filsDroit().valeur().toString();
          if (this.filsGauche().feuille() && this.filsDroit().feuille()){
            if (valeurGauche.matches("^[0-9]+$")){
              this.affecterFilsGauche(new Arbre("0"));
            }
            if (valeurDroit.matches("^[0-9]+$")){
              this.affecterFilsDroit(new Arbre("0"));
            }
            if (valeurGauche.equals("x")){
              this.affecterFilsGauche(new Arbre("1"));
            }
            if (valeurDroit.equals("x")){
              this.affecterFilsDroit(new Arbre("1"));
            }
          }else if (this.filsGauche().feuille() ^ this.filsDroit().feuille()){
            if (valeurGauche.matches("^[0-9]+$")){
              this.affecterFilsGauche(new Arbre("0"));
              this.filsDroit().derivePoly();
            }else if (valeurGauche.equals("x")){
              this.affecterFilsGauche(new Arbre("1"));
              this.filsDroit().derivePoly();
            }
            if (valeurDroit.matches("^[0-9]+$")){
              this.affecterFilsDroit(new Arbre("0"));
              this.filsGauche().derivePoly();
            }else if (valeurDroit.equals("x")){
              this.affecterFilsDroit(new Arbre("1"));
              this.filsGauche().derivePoly();
            }
          }
        }else if(this.valeur().equals("^")){
          this.changeThis(new Arbre("*",this.filsDroit(),new Arbre("^",this.filsGauche(),new Arbre("-",this.filsDroit(),new Arbre("1")))));
        }else if(this.valeur().equals("*")){
          if (this.filsGauche().valeur().toString().matches("^[0-9]+$")){
            if (this.filsDroit().valeur().equals("x")){
              this.changeThis(this.filsGauche());
            }else if (!this.filsDroit().feuille()){
              this.filsDroit().derivePoly();
            }
          }
        }
      }
    }
  }
  //This function can transform the tree to the corresponding equation STRING.
  public String arbreVersTexte(){
    String res = "";
    if (this.valeur().equals("+")||this.valeur().equals("-")||this.valeur().equals("*")||this.valeur().equals("/")||this.valeur().equals("^")){
      res += "(";
      res += this.filsGauche().arbreVersTexte();
      res += this.valeur().toString();
      res += this.filsDroit().arbreVersTexte();
      res += ")";
    }else{
      res += this.valeur().toString();
    }
    return res;
  }
  //This function give the derivation of a "A/B" equation, where A and B are both in the form of Polynomes.
  public void deriveRatio(){
    if (this.valeur().equals("/")){
      String eqGauche = this.filsGauche().arbreVersTexte();
      String eqDroit = this.filsDroit().arbreVersTexte();
      ManipulationArbre.generationXMLdepuisTexte(eqGauche, "nume.xml");
      ManipulationArbre.generationXMLdepuisTexte(eqDroit, "denom.xml");
      Arbre nume = ManipulationArbre.XMLVersArbre("nume.xml");
      Arbre denom = ManipulationArbre.XMLVersArbre("denom.xml");
      this.filsGauche().derivePoly();
      this.filsDroit().derivePoly();
      this.affecterFilsGauche(new Arbre("-",new Arbre("*",this.filsGauche(),denom),new Arbre("*",this.filsDroit(),nume)));
      this.affecterFilsDroit(new Arbre("*",denom,denom));
    }
  }
}
