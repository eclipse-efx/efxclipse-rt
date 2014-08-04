var f = function(token) {
	var Function = Java.type("java.util.function.Function");
	return new Function() {
		apply : function(token) {
			var SingleLineRule = Java.type("org.eclipse.jface.text.rules.SingleLineRule");
			var TagRule = Java.extend( SingleLineRule );
			var Character = Java.type("java.lang.Character");
			
			var tagRule = new TagRule("$", " ", token) {
				sequenceDetected : function(scanner, sequence, eofAllowed) {
				  var c = scanner.read();
				  var v = Character.toString(sequence[0]);
				  if (v == "$") {
				  	if (Character.toString(c) == '$') {
				  	  scanner.unread();
				  	  return false;
				  	}
				  } else if (! Character.isJavaIdentifierPart(sequence[0])) {
					scanner.unread();
				  }
				  
				  return Java.super(tagRule).sequenceDetected(scanner, sequence, eofAllowed);
				}
			};
			return tagRule;		
		}
	}; 
};

f();