class Fighter {

  boolean isVulnerable() {
    return true;
  }

  int getDamagePoints(Fighter fighter) {
    return 1;
  }
}

// TODO: define the Warrior class
class Warrior extends Fighter {

  @Override
  boolean isVulnerable() {
    return false;
  }

  @Override
  int getDamagePoints(Fighter fighter) {
    return fighter.isVulnerable() ? 10 : 6;
  }

  @Override
  public String toString() {
    return "Fighter is a Warrior";
  }
}

// TODO: define the Wizard class
class Wizard extends Fighter {

  private boolean isPrepareSpellCalled;
  
  void prepareSpell() {
    this.isPrepareSpellCalled = true;
  }

  @Override
  boolean isVulnerable() {
    return this.isPrepareSpellCalled ? false : true;
  }

  @Override
  int getDamagePoints(Fighter fighter) {
    return this.isPrepareSpellCalled ? 12 : 3;
  }

  @Override
  public String toString() {
   return "Fighter is a Wizard"; 
  }
}

