var f = function() {
	var MultiLineRule = Java.type("org.eclipse.jface.text.rules.MultiLineRule");
	var TagRule = Java.extend( MultiLineRule );
	
	var Token = Java.type("org.eclipse.jface.text.rules.Token");
	var token = new Token("__xml_tag");
	var tagRule = new TagRule("<", ">",token) {
		sequenceDetected : function(scanner, sequence, eofAllowed) {
		  
		  var c = scanner.read();
		  if (sequence[0] == '<') {
		  	if (c == '?') {
		  	  scanner.unread();
		  	  return false;
		  	}
		  	if (c == '!') {
		  	  scanner.unread();
		  	  return false;
		  	}
		  } else if (sequence[0] == '>') {
			scanner.unread();
		  }
		  
		  return Java.super(tagRule).sequenceDetected(scanner, sequence, eofAllowed);
		}
	};
	return tagRule;
};

f();