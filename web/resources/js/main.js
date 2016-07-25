jQuery(function ($) {
    $.mask.definitions['~'] = '[+-]';
    $('.data').mask('99/99/9999');
    $('.cpf').mask('999.999.999-99');
    $('.rg').mask('99.999.999-9');
    $('.telefone').mask('(99) 9999-9999');
    $('.celular').mask('(99) 9.9999-9999');
    $('.nrprocesso').mask('9999999.99.9999.999.9999');
    $('.nroficio').mask('9/9999');
});