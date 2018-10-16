<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="col-sm-offset-4 col-sm-4">
            <h1>Simple Servlet<br><small>Enter Search below:</small></h1>
    
            <form action="simple" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="searchType">Type of Search:</label>
                    <select name="searchType" id="searchType" class="form-control">
                        <option value="ACCTNUM">Account Number</option>
                        <option value="LNAME">Last Name</option>
                        <option value="FNAME">First Name</option>
                        <option value="EMAIL">Email</option>
                        <option value="IPADDR">IP Address</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="message">Search: </label>
                    <input name="message" id="message" class="form-control" />
                </div>
                <div class="col-sm-offset-4 col-sm-4">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>

            </form>
        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>