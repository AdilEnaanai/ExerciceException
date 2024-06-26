package mind.tech.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

	@ExceptionHandler(DivisionByZeroException.class)
	public ResponseEntity<String> divisionByZeroException(DivisionByZeroException ex){
		logger.error(ex.getMessage());
		return ResponseEntity.status(680).body(ex.getMessage());
	}
	
	@ExceptionHandler(NegativeRacineValueException.class)
	public ResponseEntity<String> negativeRacineValueException(NegativeRacineValueException ex){
		logger.error(ex.getMessage());
		return ResponseEntity.status(690).body(ex.getMessage());
	}
	
	@ExceptionHandler(FichierNonTrouvé.class)
	public ResponseEntity<String> FichierNonTrouvé(FichierNonTrouvé ex){
		logger.error(ex.getMessage());
		return ResponseEntity.status(691).body(ex.getMessage());
	}
	@ExceptionHandler(FichierNonLisible.class)
	public ResponseEntity<String> FichierNonLisible(FichierNonLisible ex){
		logger.error(ex.getMessage());
		return ResponseEntity.status(692).body(ex.getMessage());
	}
	@ExceptionHandler(ExpressionFormuleInvalide.class)
	public ResponseEntity<String> ExpressionFormuleInvalide(ExpressionFormuleInvalide ex){
		logger.error(ex.getMessage());
		return ResponseEntity.status(693).body(ex.getMessage());
	}
}
