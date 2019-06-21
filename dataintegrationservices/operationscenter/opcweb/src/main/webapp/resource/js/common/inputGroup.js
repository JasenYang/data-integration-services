/**
 * Created by DreamBoy on 2016/4/29.
 */
$(function () {
    $.fn.initInputGroup = function (options) {
        //1.Settings ��ʼ������
        var c = $.extend({
            'widget': 'input',
            'add': "<span class=\"glyphicon glyphicon-plus\"></span>",
            'del': "<span class=\"glyphicon glyphicon-minus\"></span>"
        }, options);

        var _this = $(this);
        //������Ϊ1���������
        addInputGroup(1);

        /**
         * ������Ϊorder���������
         * @param order �����������
         */
        function addInputGroup(order) {
            //1.�����������
            debugger;
            var inputGroup = $("<div class='input-group' style='margin: 10px 0'></div>");
            //2.�����������
            var inputGroupAddon1 = $("<span class='input-group-addon'></span>");
            //3.���������������
            inputGroupAddon1.html(" " + order + " ");
            //4.������������е�����ؼ���input��textarea��
            var widget = '', inputGroupAddon2;
            if (c.widget == 'textarea') {  // ������Ҫtextarea �ͼ���
                widget = $("<textarea class='form-control' style='resize: vertical;'></textarea>");
                inputGroupAddon2 = $("<span class='input-group-addon'></span>");
            } else if (c.widget == 'input') {
                var inputBefore = "<input class='form-control' type='text'";
                var inputAfter = "></input>";
                var input = "";
                var number = c.number;
                var data = c.data;
                for (var i = 0; i < number; i++) {
                    input = input + inputBefore + " id= '" + data.id[i] + order + " 'placeholder = '" + data.desc[i] + " 'name = '" + data.name[i] + order + "'" + inputAfter;
                    //�ж��Ƿ���Ҫ�����֤
                }
                widget = $(input);
                inputGroupAddon2 = $("<span class='input-group-btn'></span>");
            }

            //5.������������������Ĳ�����ť
            var addBtn = $("<button class='btn btn-default' type='button'>" + c.add + "</button>");
            addBtn.appendTo(inputGroupAddon2).on('click', function () {
                //6.��Ӧɾ������Ӳ�����ť�¼�
                if ($(this).html() == c.del) {
                    $(this).parents('.input-group').remove();
                } else if ($(this).html() == c.add) {
                    $(this).html(c.del);
                    addInputGroup(order + 1);
                }
                //7.�������������������
                resort();
            });
            inputGroup.append(inputGroupAddon1).append(widget).append(inputGroupAddon2);
            //��ÿ�����ɵĶ�̬inputɾ��
            // _this.empty();
            _this.append(inputGroup);
            //�����֤   // �����޸�
            if (c.data.validation) {
                for (var i = 0; i < number; i++) {
                    if (c.data.validation && c.data.validation[i]) {
                        $("#form2SystemPower").data('bootstrapValidator').addField(data.name[i] + order, {
                            validators: {
                                //     $('#form2SystemPower').bootstrapValidator('addField', data.name[i]+i, {
                                // validators: {
                                notEmpty: {
                                    message: '����ҵ�����ݲ���Ϊ��'
                                }
                            }
                        });
                    }
                }
            }
        }

        function resort() {
            var child = _this.children();
            $.each(child, function (i) {
                $(this).find(".input-group-addon").eq(0).html(' ' + (i + 1) + ' ');
            });
        }
    }
})
;