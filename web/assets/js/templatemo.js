/*

TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

*/

'use strict';
$(document).ready(function () {

  // Accordion
  var all_panels = $('.templatemo-accordion > li > ul').hide();

  $('.templatemo-accordion > li > a').click(function () {
    console.log('Hello world!');
    var target = $(this).next();
    if (!target.hasClass('active')) {
      all_panels.removeClass('active').slideUp();
      target.addClass('active').slideDown();
    }
    return false;
  });
  // End accordion

  // Product detail
  $('.product-links-wap a').click(function () {
    var this_src = $(this).children('img').attr('src');
    $('#product-detail').attr('src', this_src);
    return false;
  });
  $('#btn-minus').click(function () {
    var val = $("#var-value").html();
    val = (val == '1') ? val : val - 1;
    $("#var-value").html(val);
    $("#product-quanity").val(val);
    return false;
  });
  $('#btn-plus').click(function () {
    var val = $("#var-value").html();
    val++;
    $("#var-value").html(val);
    $("#product-quanity").val(val);
    return false;
  });
  $('.btn-size').click(function () {
    var this_val = $(this).html();
    $("#product-size").val(this_val);
    $(".btn-size").removeClass('btn-secondary');
    $(".btn-size").addClass('btn-success');
    $(this).removeClass('btn-success');
    $(this).addClass('btn-secondary');
    return false;
  });
  // End roduct detail

});

function loadMore() {
  var amount = document.getElementsByClassName("product").length;
  var price1 = $('#price1').val();
  var price2 = $('#price2').val();
  console.log(price1);


  $.ajax({
    url: "/Shoes_Store/loadMore",
    type: "get", //send it through get method
    data: {
      tabindex: amount,
      price1: price1,
      price2: price2

    },
    success: function (data) {
      var row = document.getElementById("content");
      row.innerHTML += data;
    },
    error: function (xhr) {
      //Do Something to handle error
    }
  });


}

function loadMoreFill() {
  var amount2 = document.getElementsByClassName("product").length

  var action = $('#action').val()
  var option = $('#option').val()

  console.log(amount2);

  $.ajax({
    url: "/Shoes_Store/loadMore",
    type: "get", //send it through get method
    data: {
      action: action,
      option: option,
      tabindex: amount2
    },


    success: function (data) {
      console.log("AJAX call  success");

      var row = document.getElementById("content");
      row.innerHTML += data;
    },
    error: function (xhr) {
      //Do Something to handle error
    }
  });
}


function loadMoreCategory_Product() {
  var cateId = $('#CateID').val();
  var ammount = document.getElementsByClassName("product").length
  var action = $('#action_CateID').val();
  console.log(cateId);
  console.log(ammount);
  console.log(action);

  $.ajax({
    type: "GET",
    url: "/Shoes_Store/loadMoreByID",
    data: {
      cateId: cateId,
      tabindex: ammount,

    },

    success: function (data) {

      var row = document.getElementById("content");
      row.innerHTML += data;
    }
  });
}
// function addtoCart() {
//   var C_ID = $('#C_ID').val();
//   let P_ID = $('#getP_ID').data('id')

// console.log(P_ID);

//   // var cartItems = [];
//   // var products = document.querySelectorAll('#P_ID');
//   // var productId
//   // products.forEach(function (product) {
//   //   productId = product.value;
//   // });



//   console.log(C_ID);
//   console.log(P_ID);
//   $.ajax({
//     type: "POST",
//     url: "/Shoes_Store/addToCart",
//     data: {
//       C_ID: C_ID,
//       P_ID: P_ID
//     },

//     success: function (data) {
//       console.log("AJAX SUCCESS");

//       if (data == 'true') {
//         Toastify({
//           text: "Add to Cart Success",
//           className: "info",
//           style: {
//             background: "linear-gradient(to right, #00b09b, #96c93d)",
//           }
//         }).showToast();
//       } else {
//         Toastify({
//           text: "Add to cart Fail",
//           className: "info",
//           style: {
//             background: "linear-gradient(to right, #00b09b, #96c93d)",
//           }
//         }).showToast();
//       }
//     }
//   });
// }


// $(document).ready(function () {
//   $('#addtocart').click(function () {
//     var ProductID = [];
//     $('#card-body').each(function () {
//       var productId = $(this).find('#P_ID').val();
//       ProductID.push( {
//           P_ID : productId
//       });
//     });

//     console.log(ProductID);
//     console.log($(this).find('input[name="P_ID"]').val());

//     $.ajax({
//       url: 'addToCart',
//       type: 'POST',
//       contentType: 'application/json',
//       data: JSON.stringify(cartItems),
//       success: function (response) {
//         alert('Cart updated successfully!');
//       },
//       error: function (xhr, status, error) {
//         alert('Error: ' + error);
//         console.log(xhr.responseText);
//       }
//     });
//   });
// });


$(document).ready(function () {
  $('.addtocart').on('click', function () {
    let P_ID = $(this).data('id');
    var C_ID = $('#C_ID').val();
    console.log(C_ID);
    $.ajax({
      type: "POST",
      url: "/Shoes_Store/addToCart",
      data: {
        CustomerID: C_ID,
        ProductID: P_ID
      },

      success: function (data) {
        console.log("AJAX SUCCESS");

        if (data === 'TRUE') {
          Toastify({
            text: "Add to Cart Success",
            className: "info",
            style: {
              background: "linear-gradient(to right, #00b09b, #96c93d)",
            }
          }).showToast();
        } else {
          Toastify({
            text: "Add to cart Fail",
            className: "info",
            style: {
              background: "linear-gradient(to right, #00b09b, #96c93d)",
            }
          }).showToast();
        }
      }

    })
  });
});
 

// -------------> ADD WISH LIST <---------------//
$(document).ready(function () {
  $('.addWishList').on('click', function () {
    let P_ID = $(this).data('id');
    var C_ID = $('#C_ID').val();
    console.log(C_ID);
    $.ajax({
      type: "POST",
      url: "/Shoes_Store/addWishList",
      data: {
        CustomerID: C_ID,
        ProductID: P_ID 
      },

      success: function (data) {
        console.log("AJAX SUCCESS");

        if (data === 'TRUE') {
          Toastify({
            text: "Add to Wish List Success",
            className: "info",
            style: {
              background: "linear-gradient(to right, #00b09b, #96c93d)",
            }
          }).showToast();
        } else {
          Toastify({
            text: "Add to Wish List Fail",
            className: "info",
            style: {
              background: "linear-gradient(to right, #00b09b, #96c93d)",
            }
          }).showToast();
        }
      }

    })
  });
});



//  total cart 
var PriceElement = document.querySelectorAll(".moneyOfProduct")
var total = 0;

PriceElement.forEach(element => {

  var value = parseFloat(element.getAttribute('data-value'))
  total += value;
  console.log(value);
});
console.log(total);

document.getElementById("totalCart").innerText += total;

console.log(document.getElementById("totalCart"));








// get quantity 


var add = document.querySelectorAll("#Add_Quantity")

add.forEach(element => {
  element.addEventListener('change', (event) => {
    const value = event.target.value
    const valueTitle = event.target.getAttribute('data-id');
    console.log(value);
    console.log(valueTitle);
    $.ajax({
      type: "POST",
      url: "/Shoes_Store/UpdateCart",
      data: {
        Quantity: value,
        P_ID: valueTitle
      },

      success: function (response) {


        if (response == 'TRUE') {
          Toastify({
            text: "UPDATE CART SUCCESS",
            className: "info",
            gravity: "top", // `top` or `bottom`
            position: "left",
            style: {
              background: "linear-gradient(to right, #00b09b, #96c93d)",
            }
          }).showToast();

          setTimeout(() => {
            location.reload();
          }, 2000);

        }



      }
    });
  })
})


var removeCart = document.querySelectorAll("#listBtnRemove")
console.log(removeCart);
removeCart.forEach(element => {

  element.addEventListener('click', (event) => {
    let ProductID = event.target.getAttribute('data-product-id')
    console.log(ProductID);

    $.ajax({
      type: "GET",
      url: "/Shoes_Store/DeleteCart",
      data: { P_ID: ProductID },
      success: function (data) {
        console.log('Ajax SUCCESS');
        if (data == "TRUE") {
          Toastify({
            text: "DELTE SUCCESS",
            className: "info",
            gravity: "top", // `top` or `bottom`
            position: "left",
            style: {
              background: "linear-gradient(to right, #00b09b, #96c93d)",
              color: "#ffff",

            }
          }).showToast();

          setTimeout(() => {
            location.reload();
          }, 2000);
        }
      }
    });

  })

})

//  -------------> ORDERS PROCESS
var buy = document.getElementById("checkout-cart")
var input = document.querySelectorAll("#orders-input")



buy.addEventListener('click', (event) => {
  let value = document.getElementById("totalCart").innerText
  let total = parseFloat(value)
  let check = false;
  input.forEach(element => {
    if (element.value == null || element.value === "") {

      check = false;

    } else {
      check = true;
    }

  })
  if (check == true) {
    $.ajax({
      type: "POST",
      url: "/Shoes_Store/Oders",
      data: { total: total },

      success: function (response) {

      }
    });
  } else {
    Toastify({
      text: "Please Enter Full Orders Form below !!!",
      className: "info",
      style: {
        background: "linear-gradient(to right, #00b09b, #96c93d)",
        color: "#ffff",

      }
    }).showToast();

  }


})