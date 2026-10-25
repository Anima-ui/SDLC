# Графическая часть SRS

## SysML v2

Исходная модель: `movie-ui.sysml`.

Модель проверена OpenSysML 0.10.1 в строгом режиме:

```powershell
sysml -strict -validate movie-ui.sysml
```

Главное представление создано самим OpenSysML:

```powershell
sysml movie-ui.sysml `
  -render "#tree:MovieGuideUI::Application" `
  -render-form mermaid `
  -render-style cameo `
  -render-palette tol-muted `
  -o movie-ui-diagram.mmd
```

Аналогично сформированы представления `CatalogScreen`, `CollectionScreen`, `MovieDetailsScreen` и `RecommendationsScreen`. Mermaid-файлы преобразованы в PNG без ручного редактирования схемы. Таким образом, PNG-диаграммы отражают элементы исходной модели SysML v2.

Файлы результата:

- `movie-ui-diagram.png` — структура приложения;
- `catalog-structure.png` — структура каталога;
- `collection-structure.png` — структура коллекции;
- `movie-details-structure.png` — структура карточки фильма;
- `recommendations-structure.png` — структура рекомендаций.

## Визуальные мокапы

Каталог `mockups/` содержит отдельную концепцию внешнего вида интерфейса:

- `catalog.png`;
- `movie-details.png`;
- `recommendations.png`.

HTML и CSS сохранены рядом с PNG, поэтому состав экранов можно изменять и повторно экспортировать. Эти файлы дополняют инженерные SysML v2-диаграммы и не подменяют их.
