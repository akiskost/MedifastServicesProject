$(document).ready(function() {
    $('#btn').on('click', function() {
        fetchPatientsFromJSON($('#searchInput').val().trim())
    })
})

function fetchPatientsFromJSON(lastname) {
    let xhr = new XMLHttpRequest()

    xhr.open('GET', `/finalproj/patients?lastname=${lastname}`, true)

    xhr.timeout = 30000
    xhr.ontimeout = (e) => onAPIError()

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) 
        {
            if (xhr.status === 200) {
                handleResults(JSON.parse(xhr.responseText))
            } else {
                onAPIError()
            }
        }
    }
    
    xhr.send()
}


function handleResults(response) {
    let patientsList = response;
   
    if (jQuery.isEmptyObject(response)) {
    	$(".patients-list").html("No patient was found");
    } else {   
	    let output = "<tr><th>Id</th><th>Όνομα</th><th>Επώνυμο</th></tr>";
	
	    for (let patient of patientsList) {
	        output += "<tr><td>"
	        + patient.pid
	        + "</td><td>"
	        + patient.fname
	        + "</td><td>"
	        + patient.lname
	        + "</td></tr>";
	    }
	
	    $(".patients-list").html(output);
    }
}


function onAPIError() {
    alert('API Error')
}