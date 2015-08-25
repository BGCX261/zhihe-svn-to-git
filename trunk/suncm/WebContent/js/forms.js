/***************************************
   Contact form
-------------------------------------- */


$(document).ready(function() {

  // Enhance style of form elements.

  $('legend').each(function(index) {
    $(this).replaceWith('<h4>' + $(this).text() + '</h4>');
  });

  $('form :input')
  .filter('.required')
    .prev('label').addClass('req-label');
  $('form :input').filter('[type!=hidden]').next().next().hide();
  //��change����blur�������ļ�ѡ��������
  $('form :input').blur(function() {
	    $(this).parents('li:first').removeClass('warning')
	    .find('span.error-message').removeClass('error-message');
	    if ($(this).hasClass('required')) {//����������Ҫ���зǿ��ж�
	      var $listItem = $(this).parents('li:first');
	      if (!isEmpty(this.value)) {
	    	var texttmp = $(this).prev('label').text();
	    	texttmp = texttmp.replace('\*','');
	        var errorMessage = texttmp+"����Ϊ��";
	        $(this).next()
	          .addClass('error-message')
	          .text(errorMessage)
	          .next().attr('src',basePath+'img/check_error.gif').show();
	        $listItem.addClass('warning');
	      }
	    }
	    //����Ѿ��д���Ͳ����д���У����
	    if($(this).hasClass('limitlen') && !$(this).next().hasClass("error-message")){
	    	var $listItem = $(this).parents('li:first');
	    	var texttmp = $(this).prev('label').text();
	    	texttmp = texttmp.replace('\*','');
	    	var thislength = getMixtureLength(this.value);
		      if (thislength>$(this).attr('maxlength')) {
		        var errorMessage = texttmp + "���ܳ���"+ $(this).attr('maxlength') +"���ַ���" + $(this).attr('maxlength')/2 + "������";
		        $(this).next()
		          .addClass('error-message')
		          .text(errorMessage).next().attr('src',basePath+'img/check_error.gif').show();
		        $listItem.addClass('warning');
		      }
	    }
	    if(!$(this).next().hasClass("error-message")){
	    	$(this).next()
	          .addClass('ok-message')
	          .text('У��ͨ��').next().attr('src',basePath+'img/check_right.gif').show();
  		}
	    
  });
  $('form').submit(function() {
	    $('#submit-message').remove();
	    $(':input.required').trigger('blur');
	    var numWarnings = $('.warning', this).length;
	      if (numWarnings) {
	        var fieldList = [];
	        $('.warning label').each(function() {
	          fieldList.push($(this).text().replace('\*',''));
	        });
	        $('<div></div>')
	        .attr({
	          'id': 'submit-message', 
	          'class': 'warning'
	        })
	        .append('������������������Ĵ��󣬹�' + 
	                                      numWarnings + '��:<br />')
	        .append('&bull; ' + fieldList.join('<br />&bull; '))
	        .insertBefore('#send');
	      return false;
	    }});
});



 /* var requiredFlag = ' * ';
  var conditionalFlag = ' ** ';
  var requiredKey = $('input.required:first')
                               .next('span').text();
  var conditionalKey = $('input.conditional:first')
                               .next('span').text();
  
  requiredKey = requiredFlag + 
             requiredKey.replace(/^\((.+)\)$/,'$1');
  conditionalKey = conditionalFlag + 
            conditionalKey.replace(/\((.+)\)/,'$1');

  $('<p></p>')
    .addClass('field-keys')
    .append(requiredKey + '<br />')
    .append(conditionalKey)
    .insertBefore('#contact');

  $('form :input')
    .filter('.required')
      .next('span').text(requiredFlag).end()
      .prev('label').addClass('req-label').end()
    .end()
    .filter('.conditional')
      .next('span').text(conditionalFlag);

  // Checkbox toggle: conditional text inputs.
  
  $('input.conditional').next('span').andSelf().hide()
  .end().end()
  .each(function() {
    var $thisInput = $(this);
    var $thisFlag = $thisInput.next('span');
    $thisInput.prev('label').find(':checkbox')
    .attr('checked', false)
    .click(function() {
      if (this.checked) {
        $thisInput.show().addClass('required');
        $thisFlag.show();
        $(this).parent('label').addClass('req-label');
      } else {
        $thisInput.hide().removeClass('required').blur();
        $thisFlag.hide();
        $(this).parent('label').removeClass('req-label');
      }
    });
  });

  // Validate fields on blur.
  
  $('form :input').blur(function() {
    $(this).parents('li:first').removeClass('warning')
    .find('span.error-message').remove();
    
    if ($(this).hasClass('required')) {
      var $listItem = $(this).parents('li:first');
      if (this.value == '') {
        var errorMessage = 'This is a required field';
        if ($(this).is('.conditional')) {
          errorMessage += ', when its related ' + 
                                  'checkbox is checked';
        }
        $('<span></span>')
          .addClass('error-message')
          .text(errorMessage)
          .appendTo($listItem);
        $listItem.addClass('warning');
      }
    }

    if (this.id == 'email') {
      var $listItem = $(this).parents('li:first');
      if ($(this).is(':hidden')) {
        this.value = '';
      }
      if (this.value != '' && 
      !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value)) {
        var errorMessage = 'Please use proper e-mail format'
                                  + ' (e.g. joe@example.com)';
        $('<span></span>')
          .addClass('error-message')
          .text(errorMessage)
          .appendTo($listItem);
        $listItem.addClass('warning');
      }
    }
  });

  // Validate form on submit.
  
  $('form').submit(function() {
    $('#submit-message').remove();
    $(':input.required').trigger('blur');
    var numWarnings = $('.warning', this).length;
      if (numWarnings) {
        var fieldList = [];
        $('.warning label').each(function() {
          fieldList.push($(this).text());
        });
        $('<div></div>')
        .attr({
          'id': 'submit-message', 
          'class': 'warning'
        })
        .append('Please correct errors with the following ' + 
                                      numWarnings + ' fields:<br />')
        .append('&bull; ' + fieldList.join('<br />&bull; '))
        .insertBefore('#send');
      return false;
    };
  });*/



