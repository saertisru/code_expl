Ext.Loader.setConfig({enabled: true});

// указываем нашу папку с framework'ом
Ext.Loader.setPath('Ext', 'js/extjs');

var formPanel=Ext.create('Ext.form.Panel',{
        title: 'Форма Запроса',
        bodyStyle:'padding:5px 5px 0',
        
        anchor:'50% 20%',
        items: [{
            xtype: 'filefield',
            name: 'file',
            fieldLabel: 'Выберите файл: ',
            msgTarget: 'side',
            allowBlank: false
        }],
        buttons: [{
            text: 'Загрузить файл',
            handler: function(){
                var form = this.up('form').getForm();
                if (form.isValid()) {
                        form.submit({
                        url: 'upload',
                        waitMsg: 'Загрузка...',
                        success: function(fp, o){
                            Ext.Msg.alert('Загрузка прошла успешно', 'Файл ' +o.result.file +" загружен");
                        },
						failure:function(fp, o){
							 Ext.Msg.alert('Загрузка прошла yt успешно', o.result.msg);
						}
                    });
                }
            }
        }]
    });

Ext.application({
    requires: ['Ext.panel.Panel'],
    name: 'app',
	width: 800,
	height: 480,
    appFolder: '/js',
	layout: 'fit',
	
    renderTo: Ext.getBody(),
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'border',
            items: [
                formPanel
            ]
        });
    }
})