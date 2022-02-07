/**
 * 
 */
function bannerLink(link){
	
	var location = window.location.href;
	
	$.ajax
	({
		type:		"post"
	  , dataType:	"text"
	  , url:		"/bannerLink"
	  , data:		{ location:location, link:link}
	  , async:		false
	  , success:	function(data) {
		  window.location.href = link;
		}
	  , error:		function(xhr, status, error) {
		  window.location.href = link;
		}
	});
}

