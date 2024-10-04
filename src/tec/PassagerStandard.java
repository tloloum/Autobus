package tec;

class PassagerStandard extends MonteeRepos{
  
  public PassagerStandard(java.lang.String nom, int destination) {
    super(nom, destination, new ArretCalme());
  } 

}