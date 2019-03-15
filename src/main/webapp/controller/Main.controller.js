sap.ui.define([
	"com/penninkhof/odata/controller/BaseController",
	"sap/ui/model/Filter",
	"sap/ui/model/FilterOperator"
], function(Controller, Filter, FilterOperator) {
	"use strict";

	var companys;
	var oModel;
	var _this;
	
	return Controller.extend("com.penninkhof.odata.controller.Main", {

		onInit: function() {
			this.ui = new sap.ui.model.json.JSONModel({count: 0});
			this.getView().setModel(this.ui, "ui");
			this.model = this.getComponent().getModel();
			
			//oModel= new sap.ui.model.odata.v2.ODataModel("http://localhost:8080/odata.svc/",false);		
			this.model.setUseBatch(false);
			//this._initList();
		},
		
		_initList : function(){	      
			//var oSupplier = oModel.getData("/Companys(1)/PersonDetails");
			_this = this;

			oModel.read("/Companys", {
		        success: function(odata){		        	
		        	_this.companys = odata.results;
		        	_this.setPersons(_this.companys,0);
		        	console.log("company2="+ JSON.stringify(_this.companys));
		        }
		    });
			
			console.log("company3="+ JSON.stringify(_this.companys));	
				
		},
		
		setPersons: function(list, num){
			//var that = this;
			var maxLength = list.length;
			
			if(num == maxLength){
				var listControl = _this.getView().byId("list");
				console.log("company="+ JSON.stringify(_this.companys));
				var list = _this.companys;
				for(var i=0; i < list.length; i++ ){
					var hBox = new sap.m.HBox({
						alignItems:"Center",
						justifyContent:"SpaceBetween",
						height: "8rem"
						
					});
					
					var text = new sap.m.Text({
						text: list[i].Name + list[i].Address + 	JSON.stringify(list[i].Persons[1].Name)
					});
					
					hBox.addItem(text);
										
					var item = new sap.m.CustomListItem({
						content: hBox
					});
					
					listControl.addItem(item);
					
					console.log("company1="+ JSON.stringify(_this.companys[i].Persons[0].Name));
				}
				return;
			}
			oModel.read('/Companys('+list[num].Id+ ')/PersonDetails' ,{
				success:function(odata){
					_this.companys[num].Persons = odata.results;
					num++;
					_this.setPersons(list, num);
				}
			})			
			
		},
		
		onSearchPressed: function(event) {
			var search = event.getParameters().query;
			this.getView().byId("table").getBinding("items").filter(
				[ new Filter([
					new Filter("FirstName", FilterOperator.Contains, search),
					new Filter("LastName", FilterOperator.Contains, search)
				], false)]);
		},

		onUpdateFinished: function(event) {
			this.ui.setProperty("/count", event.getParameter("total"));	
		},
		
		onAddPressed: function() {
			this.getRouter().navTo("AddMember");
		}

	});

});
