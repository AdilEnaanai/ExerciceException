package mind.tech.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mind.tech.exception.DivisionByZeroException;
import mind.tech.exception.ExpressionFormuleInvalide;
import mind.tech.exception.FichierNonLisible;
import mind.tech.exception.FichierNonTrouvé;
import mind.tech.exception.NegativeRacineValueException;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@RestController
public class ExerciceController {

	@GetMapping("division")
	public double division(@RequestParam int a, @RequestParam int b) {
		if (b==0) throw new DivisionByZeroException("Division par zéro");
		return a/b;
	}
	@GetMapping("racine")
	public double racine(@RequestParam int a) {
		if (a<0) throw new NegativeRacineValueException("Impossible de calculer la racine carée d'un nombre négatif en IR");
		return Math.sqrt(a);
	}
	@GetMapping("formule")
	public double formule() throws IOException {
		File file=new File("src/main/resources/static/formule.txt");
		if (!file.exists()) {throw new FichierNonTrouvé("Fichier "+file.getPath()+" inexistant");}
		else if (!file.canRead()){throw new FichierNonLisible("Fichier "+file.getPath()+" inexistant");}
		else {
			String formule=Files.readString(file.toPath());
			Expression expression = new ExpressionBuilder(formule).build();
			if (!expression.validate().isValid()) {throw new ExpressionFormuleInvalide("Expression de formule invalide");}
			// Évaluez l'expression
			else {return expression.evaluate();}

		}
		
	}
	
}
