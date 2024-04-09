import java.util.ArrayList;

public class CryptoMarche
{
	private static CryptoMarche marche;

	private ArrayList<Portefeuille> portefeuilles;

	private CryptoMarche()
	{
		portefeuilles = new ArrayList<Portefeuille>();
	}

	public static CryptoMarche getInstance()
	{
		if(marche == null){ marche = new CryptoMarche();}
		return marche;
	}

	public void ajouter(Portefeuille p)
	{
		portefeuilles.add(p);
	}

	/**
	* Cette fonction recherche sur le marché tous les portefeuilles 
	* du propriétaire et calcule son capital en euros. 
	* @param proprietare
	* @return capital en euros du propriétare.
	*/
	public double capitalEnEuros(String proprietaire)
	{
		double capitale = 0.0;

		for(Portefeuille p : portefeuilles)
		{
			if (p.getProprietaire().equals(proprietaire)) 
			{
				capitale += p.valeurEnEuros();
			}
		}
		return capitale;
	}

	/**
	* Cette fonction recherche sur le marché tous les portefeuilles 
	* d'un type de devise et calcule le volume total de capital de 
	* cette devise sur le marché 
	* @param monnaie
	* @return capital total en circulation de la cryptomonnaie (en euros).
	*/
	public double capitalMonneaie(Cryptomonnaie monnaie)
	{
		double totalCapital = 0.0;

		for (Portefeuille p : portefeuilles)
		{
			if (p.getMonnaie().equals(monnaie))
			{
				totalCapital += p.valeurEnEuros();
			}
		}
		return totalCapital;
	}

	@Override
	public String toString()
	{
		String ret = "";
		for(Portefeuille p : this.portefeuilles)
		{
			ret += p.toString() + "\n";
		}
		return ret;
	}

}