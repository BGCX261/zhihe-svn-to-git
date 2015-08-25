/***************************************
   Contact form
-------------------------------------- */


$(document).ready(function() {

  $('form[id^=addwidget]').hide();
  $('form[id=addwidget0]').show();
  $('#widgetType').change(
		  function(){
			  $('form[id^=addwidget]').hide();
			  var sid = 'addwidget' + $(this).attr('value');
			  $('#'+sid).fadeIn('slow');
		  }
		  );
  /*alert($('form').serialize());
  $('input[id^=delete]').click(
	function(){
		$("#add").addClass('disabled');
		$(this).addClass('disabled');
		$.post(basePath+'web20',{"pCateId":$('#pCateId').attr('value'),"id":$(this).attr('id').replace('delete','')},
				function(){

			$("#add").removeClass('disabled');
			$(this).removeClass('disabled');
			
		});
	}
  );*/
  
});



 



