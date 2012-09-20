<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
jQuery(function($) { 
	$.getJSON("../newsellers", function(data){
		$(data).each(function(){
			if(this.level>=4&&this.level<=10)
				$("#newusers-class").append("<li>"+this.username+"  <i class='topclass-a-1'></i></li>");
			if(this.level>11&&this.level<40)
				$("#newusers-class").append("<li>"+this.username+"  <i class='topclass-a-2'></i></li>");
			if(this.level>41&&this.level<90)
				$("#newusers-class").append("<li>"+this.username+"  <i class='topclass-a-3'></i></li>");
			if(this.level>91&&this.level<150)
				$("#newusers-class").append("<li>"+this.username+"  <i class='topclass-a-4'></i></li>");
			if(this.level>151&&this.level<250)
				$("#newusers-class").append("<li>"+this.username+"  <i class='topclass-a-5'></i></li>");
		})
	});	
});
</script>
<div class="divself">
	<p>最新加入</p>
	<ul id="newusers-class">
	</ul>
</div>