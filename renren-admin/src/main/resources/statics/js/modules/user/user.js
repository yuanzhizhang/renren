$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/user/list',
        datatype: "json",
        colModel: [			
			{ label: 'uid', name: 'uid', index: 'uid', width: 50, key: true },
			{ label: '', name: 'username', index: 'username', width: 80 }, 			
			{ label: '', name: 'upassword', index: 'upassword', width: 80 }, 			
			{ label: '', name: 'usex', index: 'usex', width: 80 }, 			
			{ label: '', name: 'uaddress', index: 'uaddress', width: 80 }, 			
			{ label: '', name: 'ubirthday', index: 'ubirthday', width: 80 }, 			
			{ label: '', name: 'unickname', index: 'unickname', width: 80 }, 			
			{ label: '', name: 'ustatus', index: 'ustatus', width: 80 }, 			
			{ label: '', name: 'uscore', index: 'uscore', width: 80 }, 			
			{ label: '', name: 'registTime', index: 'regist_time', width: 80 }, 			
			{ label: '', name: 'lv', index: 'lv', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.user = {};
		},
		update: function (event) {
			var uid = getSelectedRow();
			if(uid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(uid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.user.uid == null ? "user/user/save" : "user/user/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.user),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var uids = getSelectedRows();
			if(uids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "user/user/delete",
                        contentType: "application/json",
                        data: JSON.stringify(uids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(uid){
			$.get(baseURL + "user/user/info/"+uid, function(r){
                vm.user = r.user;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});