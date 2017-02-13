<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link href="resources/dashboard/table/css/style.css" rel="stylesheet">
	<link href="resources/dashboard/table/css/dataTables/datatables.min.css" rel="stylesheet">
<!-- jQuery 2.1.4 -->
    <script src="resources/dashboard/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="resources/dashboard/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/dashboard/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="resources/dashboard/dist/js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="resources/dashboard/dist/js/demo.js"></script>
    <!-- page script -->
    <script src="resources/dashboard/table/js/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="resources/dashboard/table/js/dataTables/datatables.min.js"></script>
    <script src="resources/dashboard/table/js/inspinia.js"></script>
    <script src="resources/dashboard/table/js/pace/pace.min.js"></script>
    <script src="resources/dashboard/table/js/metisMenu/jquery.metisMenu.js"></script>


	<!-- InputMask -->
	<script src="resources/dashboard/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="resources/dashboard/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="resources/dashboard/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<!-- date-range-picker -->
	<script src="resources/dashboard/bootstrap/js/moment.min.js"></script>
	<script src="resources/dashboard/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap datepicker -->
	<script src="resources/dashboard/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- bootstrap color picker -->
	<script
		src="resources/dashboard/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<!-- bootstrap time picker -->
	<script src="resources/dashboard/plugins/timepicker/bootstrap-timepicker.min.js"></script>
	<!-- SlimScroll 1.3.0 -->
	<!-- iCheck 1.0.1 -->
	<script src="resources/dashboard/plugins/iCheck/icheck.min.js"></script>
    <!-- Page-Level Scripts -->
    <script>
    $(function() {
		$("#example1").DataTable();
		//Datemask dd/mm/yyyy
		$("#datemask").inputmask("dd/mm/yyyy", {
			"placeholder" : "dd/mm/yyyy"
		});
		//Datemask2 mm/dd/yyyy
		$("#datemask2").inputmask("mm/dd/yyyy", {
			"placeholder" : "mm/dd/yyyy"
		});
		//Money Euro
		$("[data-mask]").inputmask();

		//Date range picker
		$('#reservation').daterangepicker();
		//Date range picker with time picker
		$('#reservationtime').daterangepicker({
			timePicker : true,
			timePickerIncrement : 30,
			format : 'MM/DD/YYYY h:mm A'
		});
		//Date range as a button
		$('#daterange-btn').daterangepicker(
				{
					ranges : {
						'Today' : [ moment(), moment() ],
						'Yesterday' : [ moment().subtract(1, 'days'),
								moment().subtract(1, 'days') ],
						'Last 7 Days' : [ moment().subtract(6, 'days'),
								moment() ],
						'Last 30 Days' : [ moment().subtract(29, 'days'),
								moment() ],
						'This Month' : [ moment().startOf('month'),
								moment().endOf('month') ],
						'Last Month' : [
								moment().subtract(1, 'month').startOf(
										'month'),
								moment().subtract(1, 'month')
										.endOf('month') ]
					},
					startDate : moment().subtract(29, 'days'),
					endDate : moment()
				},
				function(start, end) {
					$('#reportrange span').html(
							start.format('MMMM D, YYYY') + ' - '
									+ end.format('MMMM D, YYYY'));
				});

		//iCheck for checkbox and radio inputs
		$('input[type="checkbox"].minimal, input[type="radio"].minimal')
				.iCheck({
					checkboxClass : 'icheckbox_minimal-blue',
					radioClass : 'iradio_minimal-blue'
				});
		//Red color scheme for iCheck
		$(
				'input[type="checkbox"].minimal-red, input[type="radio"].minimal-red')
				.iCheck({
					checkboxClass : 'icheckbox_minimal-red',
					radioClass : 'iradio_minimal-red'
				});
		//Flat red color scheme for iCheck
		$('input[type="checkbox"].flat-red, input[type="radio"].flat-red')
				.iCheck({
					checkboxClass : 'icheckbox_flat-green',
					radioClass : 'iradio_flat-green'
				});

		//Colorpicker
		$(".my-colorpicker1").colorpicker();
		//color picker with addon
		$(".my-colorpicker2").colorpicker();

		$('.endDate').daterangepicker({
			singleDatePicker : true,
			startDate : moment()
		});
		//Timepicker
		$(".timepicker").timepicker({
			showInputs : false
		});
	});
        $(document).ready(function(){
            $('.dataTables-example').DataTable({
                pageLength: 10,
                responsive: true,
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    { extend: 'copy'},
                    {extend: 'csv'},
                    {extend: 'excel', title: 'ExampleFile'},
                    {extend: 'pdf', title: 'ExampleFile'},

                    {extend: 'print',
                     customize: function (win){
                            $(win.document.body).addClass('white-bg');
                            $(win.document.body).css('font-size', '10px');

                            $(win.document.body).find('table')
                                    .addClass('compact')
                                    .css('font-size', 'inherit');
                    }
                    }
                ]

            });
            

        });

    </script>