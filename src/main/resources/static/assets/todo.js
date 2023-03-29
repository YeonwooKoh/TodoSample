

function editTask(taskId) {

  $.ajax({
  	type: "GET",
  	url: "/getTodo",
  	data: {"taskId": taskId},
	dataType:"json",
  	success: function(data) {

		console.log(data.taskId);

        $("#taskIdEdit").val(data.taskId);
  		$("#taskNameEdit").val(data.taskName);
  		$("#dueDateEdit").val(data.dueDate);

  	},
  	error: function(xhr, status, error) {
  		alert(xhr.responseText);
  	}
  });
}

function deleteById(taskId) {
  $.ajax({

    type: "POST",
    url: "deleteTodo",
    data: {
      taskId: taskId,
    },
	success: function(){

		window.location.reload();

	}

  });

} //deleteById
