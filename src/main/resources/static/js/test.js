Ext.Loader.setConfig({enabled: true});

// указываем нашу папку с framework'ом
Ext.Loader.setPath('Ext', 'js/extjs');

// Указываем какие библиотеки подключить, можно внутри написать просто '*' и он подключит всё 
Ext.define("Classes.Person", {

    config: {
	
        fio: 'n/a',
        func_name: 'n/a',
        work_num : '0',
        rate : '0',
        acc_num : '0',
		func_num : '0', 
		moder : '50',
		pazpyd : "0",
		time : "0",
		balance : '0',
		yet : "0",
		ctaj :"0",
		kateg :"0",
		young_spec:"0",
		vred:"0",

		},
    constructor : function(config){
        this.initConfig(config);
		},
		
	getInfo : function (){
		alert("ФИО:" + this.getFio())
	}
    
});

// Метод onReady отвечает за запуск скрипта внутри анонимной функции по завершении загрузки страницы
Ext.onReady(function(){
   // Метод alert из пакета Ext.Msg равносилен стандарной JS функции alert();, 
   // первый параметр - это загаловок, второй сам текст
   Ext.Msg.alert('Загаловок','Hello World');
  var buttonForm = Ext.create('Ext.button.Button', { 
            text: 'Отправить',
            handler : function (){
            var form = Ext.getCmp('idForm').getForm();
            if(form.isValid()){
                form.submit({
                    waitMsg:'Идет отправка...',
                    url: '/test_ajax.php',
                    params : {key : 'val', key2 : 'val2'},
                    success: function(form,response) {
                        Ext.Msg.alert('Внимание','Успешно отправлено'); 
                        console.log(response.result);
                    },
                    failure : function(){
                        Ext.Msg.alert('Внимание','Какая то ошибка'); 
                    }
                });
            }else{
                Ext.Msg.alert('Внимание','Заполните ВСЕ поля'); 
            }
            }
        });
		
	var store = Ext.create('Ext.data.TreeStore', {
        root: {
            text: 'Страны СНГ',
            expanded: true,
            children:
            [{
                text: "Россия",
                children: [{
                    text: "Москва",
                    leaf: true,
					div_num : "5454"
                }, {
                    text: "Санкт-Петербург",
					div_num : "5454",
                    leaf: true
                }, {
                    text: "Волгоград",
					div_num : "5454",
                    leaf: true
                }],
                leaf: false,
                "expanded": true
            },
            {
                text: "Украина",
				children: [{
                    text: "Крым",
                    leaf: true
                }],
                leaf: false
            },
            {
                text: "Белоруссия"
            }]
        }
    });	
	
	var myTree = Ext.create('Ext.tree.Panel', {
        title: 'Страны СНГ',
        width: 200,
        height: 200,
        rootVisible: true,
        region: "west",
        store: store,
		listeners: {
            itemclick : function(tree, record, item, index, e, options) {
                var nodeText = record.raw["div_num"];
				if(nodeText != null){
					alert(nodeText);
				}else{
					console.log("div is't exist");
				}
            }
        },
		viewConfig: {
			plugins: {
					ptype: 'treeviewdragdrop'
			}
		}
    });
	
	var myForm = Ext.create('Ext.form.Panel', {
        id: 'idForm',
        region: 'center',
        title: 'Тестовая форма',
        fieldDefaults: {
            msgTarget: 'side'
        },
        defaults: {
            anchor: '100%'
        },
         that : this,
        defaultType: 'textfield',
        bodyPadding: '5 5 0',
        items: [{
            fieldLabel: 'Имя',
            name: 'first',
            allowBlank: false
        }, {
            fieldLabel: 'Email',
            name: 'email',
            vtype:'email'
        }, {
            fieldLabel: 'Дата',
            name: 'dob',
            xtype: 'datefield'
        }, {
            fieldLabel: 'Сколько лет',
            name: 'age',
            xtype: 'numberfield',
            minValue: 0,
            maxValue: 100
        }, {
            xtype: 'timefield',
            fieldLabel: 'Время',
            name: 'time',
            minValue: '8:00am',
            maxValue: '6:00pm'
        },
			{
			xtype: 'htmleditor',
			name: 'text',
			fieldLabel: 'Текст'
		}],
        
        buttons: [
		{
				xtype: 'button',
				text: 'Button 1',
				handler: function(){
					store.sort('text', 'ASC');
				}
			},
		buttonForm]
  });
  
   var panel = Ext.create("Ext.window.Window", {
	title: "My panel",
	width: 900,
	height: 600,
	draggable: true,
	autoShow: true,
	closable: false,
	layout: 'border',
	defaults : {
		padding: '3',
		
	},
	items:[
	
	myTree,
	
	myForm,
	
	{
		xtype: 'tabpanel',
		region: 'south',
		height: 200,
		title: 'Таб панель',
		items: [
			{
				title: 'Первая вкладка',
				html: 'Контент первой вкладки',
			},			
			{
				title: 'вторая вкладка',
				html: 'контент второй вкладки'
			}
		]
		
	}
	]
      })
	  
}); 


