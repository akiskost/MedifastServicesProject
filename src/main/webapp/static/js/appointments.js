$(document).ready(function() {
    $('#btn').on('click', function() {
        fetchPatientsFromJSON($('#searchInput').val().trim())
    })
})

function fetchPatientsFromJSON() {
    let xhr = new XMLHttpRequest()

    xhr.open('GET', `/finalproj/appointments`, true)

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
    let appointmentsList = response;

    if (jQuery.isEmptyObject(response)) {
        $(".appointments-list").html("No Appointments found");
    } else {
        let output = "<tr><th>Id</th><th>Όνομα</th><th>Επώνυμο</th></tr>";

        for (let appointment of appointmentsList) {
            output += "<tr><td>"
                + appointment.apid
                + "</td><td>"
                + appointment.fname
                + "</td><td>"
                + appointment.lname
                + "</td></tr>"
                + appointment.date
                + "</td></tr>"
            + appointment.exam
            + "</td></tr>"
            + appointment.result
            + "</td></tr>";

        }

        $(".appointments-list").html(output);
    }
}


function onAPIError() {
    alert('API Error')
}