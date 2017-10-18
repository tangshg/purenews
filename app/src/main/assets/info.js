function IsImageLoadedNew(night) {
    var img = event.srcElement;
    if (img.src.indexOf("picture_place_holder.png") > 0 || img.src.indexOf("picture_place_holder_night.png") > 0) {
        if (night == "0") {
            var loading = "file:///android_asset/ruanmei_webview_loadingimage.png";
            img.src = loading;
        } else {
            var loading = "file:///android_asset/ruanmei_webview_loadingimage_night.png";
            img.src = loading;
        }
    } else if (img.complete) {
        var src = img.attributes['originsrc'].nodeValue;
        ProxyClickPicture.clickImg(src);
    }
}


function IsGifImageLoadedNew(night) {
    var img=event.srcElement;
    if (img.src.indexOf("picture_place_gif_holder.png") > 0 || img.src.indexOf("picture_place_holder_gif_night.png") > 0) {
        if (night == "0") {
            var loading = "file:///android_asset/ruanmei_webview_loadingimage.png";
            img.src = loading;
        } else {
            var loading = "file:///android_asset/ruanmei_webview_loadingimage_night.png";
            img.src = loading;
        }
    } else if (img.complete) {
         var src = img.attributes['originsrc'].nodeValue;
         ProxyClickPicture.clickImg(src);
     }
}

function imageload()
{
  var img=event.srcElement;

  if(img.src.indexOf("ruanmei_webview_loadingimage.png") > 0 || img.src.indexOf("ruanmei_webview_loadingimage_night.png") > 0)
  {
      img.src = img.attributes['originsrc'].nodeValue;
  }
  else
  {
  }
}

function IsImageLoaded()
{
    var img=event.srcElement;

    if(img.src.indexOf("picture_place_holder.png") > 0)
    {
      img.src = img.attributes['loadingsrc'].nodeValue;
    }
    else if(img.src.indexOf("ruanmei_webview_loadingimage.png") > 0)
    {
    }
    else
    {
       if(img.complete)
       {
           var imagesrc = img.attributes['originsrc'].nodeValue;
           ProxyClickPicture.clickImg(imagesrc);
       }
       else
       {
       }
    }
}

function IsGifImageLoaded()
{
    var img=event.srcElement;

    if(img.src.indexOf("picture_place_gif_holder.png") > 0)
    {
        img.src = img.attributes['loadingsrc'].nodeValue;
    }
    else if(img.src.indexOf("ruanmei_webview_loadingimage.png") > 0)
    {
    }
    else
    {
         if(img.complete)
         {
            //ios ���ͼƬʹ��
             var imagesrc = img.attributes['originsrc'].nodeValue;
             //document.location = imagesrc.replace("http://","ruanmeipic://");
             ProxyClickPicture.clickImg(imagesrc);
         }
         else
         {
             //δ�������ʱ���ݲ��Ŵ�ͼƬ���Ժ�����޸�
             //img.src = img.attributes['originsrc'].nodeValue;
         }
    }
}
  function IsImageLoaded1()
          {
              var img=event.srcElement;

              if(img.src.indexOf("picture_place_holder.png") > 0)
              {
                  img.src = img.attributes['loadingsrc'].nodeValue;
              }
              else if(img.src.indexOf("ruanmei_webview_loadingimage.png") > 0)
              {
              }
              else
              {
                   if(img.complete)
                   {
						//ios ���ͼƬʹ��
                       var imagesrc = img.attributes['originsrc'].nodeValue;
                       //document.location = imagesrc.replace("http://","ruanmeipic://");
                   }
                   else
                   {
                       //δ�������ʱ���ݲ��Ŵ�ͼƬ���Ժ�����޸�
                       //img.src = img.attributes['originsrc'].nodeValue;
                   }
              }
          }

/*投票相关 2016-10-12*/
function submitVote(id, votetype) {
    var x = document.getElementsByName("checkbox" + id + "[]");
    var m = 0;
    var itemids = '';
    for (var i = 0; i < x.length; i++) {
        if (x[i].checked) {
            m++;
            itemids += x[i].value + ',';
        }
    }
    if (m == 0) {// 没有选项
        ProxyClickPicture.notifyVote(id, 'voteEmpty:' + votetype);
        return;
    }
    if (m > votetype) {// 选项数量超出限制
        ProxyClickPicture.notifyVote(id, 'voteError:' + votetype);
        return;
    }

    // 成功投票
    ProxyClickPicture.notifyVote(id, 'voteSuccess:' + id + ":" + itemids);
}

